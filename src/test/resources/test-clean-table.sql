SET REFERENTIAL_INTEGRITY FALSE;
DELETE FROM group_teacher;
DELETE FROM user;
ALTER TABLE user ALTER COLUMN id RESTART WITH 1;
DELETE FROM role;
ALTER TABLE role ALTER COLUMN id RESTART WITH 1;
DELETE FROM role_category;
ALTER TABLE role_category ALTER COLUMN id RESTART WITH 1;
DELETE FROM educational_group;
ALTER TABLE educational_group ALTER COLUMN id RESTART WITH 1;
DELETE FROM status;
ALTER TABLE status ALTER COLUMN id RESTART WITH 1;
DELETE FROM status_category;
ALTER TABLE status_category ALTER COLUMN id RESTART WITH 1;
DELETE FROM specialization;
ALTER TABLE specialization ALTER COLUMN id RESTART WITH 1;
DELETE FROM location;
ALTER TABLE location ALTER COLUMN id RESTART WITH 1;
DELETE FROM budget_owner;
ALTER TABLE budget_owner ALTER COLUMN id RESTART WITH 1;
DELETE FROM expert;
DELETE FROM room;
ALTER TABLE room ALTER COLUMN id RESTART WITH 1;
DELETE FROM event;
ALTER TABLE event ALTER COLUMN id RESTART WITH 1;
DELETE FROM event_type;
ALTER TABLE event_type ALTER COLUMN id RESTART WITH 1;
SET REFERENTIAL_INTEGRITY TRUE;