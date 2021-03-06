package com.softserve.teamproject.service.impl;

import com.softserve.teamproject.dto.EditStudentDto;
import com.softserve.teamproject.dto.StudentDto;
import com.softserve.teamproject.entity.EnglishLevel;
import com.softserve.teamproject.entity.Expert;
import com.softserve.teamproject.entity.Group;
import com.softserve.teamproject.entity.Student;
import com.softserve.teamproject.entity.assembler.StudentResourceAssembler;
import com.softserve.teamproject.entity.resource.StudentResource;
import com.softserve.teamproject.repository.EnglishLevelRepository;
import com.softserve.teamproject.repository.ExpertRepository;
import com.softserve.teamproject.repository.GroupRepository;
import com.softserve.teamproject.repository.StudentRepository;
import com.softserve.teamproject.service.MessageByLocaleService;
import com.softserve.teamproject.service.StudentService;
import com.softserve.teamproject.validation.StudentValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class StudentServiceImpl implements StudentService {

  private StudentRepository studentRepository;
  private StudentResourceAssembler studentResourceAssembler;
  private GroupRepository groupRepository;
  private StudentValidator studentValidator;
  private EnglishLevelRepository englishLevelRepository;
  private MessageByLocaleService messageByLocaleService;
  private ExpertRepository expertRepository;

  @Autowired
  public void setExpertRepository(ExpertRepository expertRepository) {
    this.expertRepository = expertRepository;
  }

  @Autowired
  public void setStudentRepository(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Autowired
  public void setStudentResourceAssembler(
      StudentResourceAssembler studentResourceAssembler) {
    this.studentResourceAssembler = studentResourceAssembler;
  }

  @Autowired
  public void setGroupRepository(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }

  @Autowired
  public void setStudentValidator(StudentValidator studentValidator) {
    this.studentValidator = studentValidator;
  }

  @Autowired
  public void setEnglishLevelRepository(EnglishLevelRepository englishLevelRepository) {
    this.englishLevelRepository = englishLevelRepository;
  }

  @Autowired
  public void setMessageByLocaleService(
      MessageByLocaleService messageByLocaleService) {
    this.messageByLocaleService = messageByLocaleService;
  }

  /**
   * Gets students by group id.
   *
   * @param groupId is id of a group
   * @return students by group id
   */
  public Iterable<StudentResource> getStudentsByGroupId(Integer groupId) {
    return convertToResource(studentRepository.getStudentsByGroupId(groupId));
  }

  /**
   * Gets all students.
   *
   * @return all students
   */
  public Iterable<StudentResource> getAllStudents() {
    return convertToResource(studentRepository.findAll());
  }

  private Iterable<StudentResource> convertToResource(Iterable<Student> students) {
    List<StudentResource> studentResources = new ArrayList<>();
    students.forEach(student -> studentResources.add(studentResourceAssembler.toResource(student)));
    return studentResources;
  }

  /**
   * Adds students to the given group.
   *
   * @param students we have to add
   * @param groupId is groups's id in which we have to add students
   * @param userName nickname of current user
   * @return student list on HATEOAS style
   */
  @Override
  public Iterable<StudentResource> addStudents(List<Student> students, Integer groupId,
      String userName) {
    Group group = groupRepository.findOne(groupId);
    studentValidator.checkCoordinatorLocationToManipulateStudent(group, userName);
    for (Student student : students) {
      student.setGroup(group);
      if (student.getFirstName() == null) {
        throw new IllegalArgumentException(
            messageByLocaleService.getMessage("illegalArgs.student.firstName")
        );
      }
      if (student.getLastName() == null) {
        throw new IllegalArgumentException(
            messageByLocaleService.getMessage("illegalArgs.student.lastName")
        );
      }
      if (student.getEnglishLevel() == null) {
        throw new IllegalArgumentException(
            messageByLocaleService.getMessage("illegalArgs.student.englishLevel")
        );
      }
      if (student.getTestApprovedByExpert() == null) {
        throw new IllegalArgumentException(
            messageByLocaleService.getMessage("illegalArgs.student.expert")
        );
      }
    }
    studentRepository.save(students);
    return students.stream().map(studentResourceAssembler::toResource).collect(Collectors.toList());
  }

  /**
   * Updates students.
   *
   * @param students we have to update
   * @param userName nickname of current user
   * @return updated students in HATEOAS style
   */
  @Override
  public Iterable<StudentResource> updateStudents(List<Student> students, String userName) {
    List<StudentResource> studentResourceList = new ArrayList<>();
    for (Student student : students) {
      updateSingleStudent(student, userName);
      StudentResource studentResource = studentResourceAssembler.toResource(student);
      studentResourceList.add(studentResource);
    }
    return studentResourceList;
  }

  /**
   * Updates single student.
   *
   * @param student we have to update
   * @param userName nickname of current user
   * @return updated student
   */
  @Override
  public Student updateSingleStudent(Student student, String userName) {
    Group group = studentRepository.findOne(student.getId()).getGroup();
    studentValidator.checkCoordinatorLocationToManipulateStudent(group, userName);
    studentRepository.save(student);
    return student;
  }

  /**
   * Gets student by given id
   *
   * @param id given student's id
   * @return StudentResource object for this student
   */
  @Override
  public StudentResource getStudentResourceById(Integer id) {
    Student student = studentRepository.findOne(id);
    if (student == null) {
      return null;
    }
    return studentResourceAssembler.toResource(student);
  }

  /**
   * Updates given student
   *
   * @param student student with new data
   * @return StudentResource object for updated student
   */
  @Override
  public StudentResource updateStudent(Student student) {
    student = studentRepository.save(student);
    return studentResourceAssembler.toResource(student);
  }


  public List<StudentDto> getAllStudentDto() {
    List<Student> allStudents = studentRepository.findAll();
    return allStudents.stream().map(StudentDto::new).collect(Collectors.toList());
  }

  @Override
  public EditStudentDto findStudentToEdit(int studentId) {
    List<String> englishLevels = englishLevelRepository.findAll().stream()
        .map(EnglishLevel::getName)
        .collect(Collectors.toList());
    List<String> experts = expertRepository.findAll().stream().map(Expert::getExpertName).collect(
        Collectors.toList());
    List<String> groups = groupRepository.findAll().stream().map(Group::getName).collect(
        Collectors.toList());
    EditStudentDto editStudentDto = null;
    try {
      if (studentId == -1) {
        editStudentDto = new EditStudentDto();
      } else {
        Student student = studentRepository.findOne(studentId);
        editStudentDto = new EditStudentDto(student);
      }
      return editStudentDto;
    } finally {
      editStudentDto.setGroups(groups);
      editStudentDto.setExperts(experts);
      editStudentDto.setEnglishLevels(englishLevels);
    }
  }

  @Override
  public void saveStudent(StudentDto studentDto) {
    Student student = new Student();
    student.setId(studentDto.getId());
    Group group = groupRepository.findByName(studentDto.getGroup());
    Expert expert = expertRepository.findByExpertName(studentDto.getExpert());
    EnglishLevel englishLevel = englishLevelRepository.findByName(studentDto.getEnglishLevel());
    student.setGroup(group);
    student.setTestApprovedByExpert(expert);
    student.setEnglishLevel(englishLevel);
    student.setFirstName(studentDto.getFirstName());
    student.setLastName(studentDto.getLastName());
    student.setEntryScore(studentDto.getEntryScore());
    student.setIncomingTest(studentDto.getIncomingTest());
    studentRepository.save(student);
  }

  @Override
  public void deleteStudent(int studentId) {
    studentRepository.deleteById(studentId);
  }
}

