-- 중복되지 않도록 INSERT 전에 삭제
DELETE FROM candidate;
ALTER TABLE candidate ALTER COLUMN candidate_id RESTART WITH 1;

-- FE_LEADER 후보들
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('권동욱', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('김영서', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('김서연', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('김철흥', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('송아영', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('신수진', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('원채영', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('이주희', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('최서연', 0, 'FE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('한서정', 0, 'FE_LEADER');

-- BE_LEADER 후보들
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('박정하', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('서채연', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('김준형', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('박서연', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('박채연', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('한혜수', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('오지현', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('이석원', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('최근호', 0, 'BE_LEADER');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('임도현', 0, 'BE_LEADER');

-- DEMO_DAY 후보들
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('이어드림', 0, 'DEMO_DAY');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('인플루이', 0, 'DEMO_DAY');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('팝업사이클', 0, 'DEMO_DAY');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('프로메사', 0, 'DEMO_DAY');
INSERT INTO candidate (name, vote_count, vote_type) VALUES ('하니홈', 0, 'DEMO_DAY');
