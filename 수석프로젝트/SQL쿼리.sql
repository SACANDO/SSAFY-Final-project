-- User Table Dummy Data
INSERT INTO `suseok`.`User` 
(`user_id`, `user_pwd`, `user_name`, `user_nick`, `email`, `address`, `img`, `phone`, `exposure`) 
VALUES
('user01', 'password1', 'John Doe', 'johnny', 'john.doe@example.com', '123 Main St', 'img1.jpg', '123-456-7890', 1),
('user02', 'password2', 'Jane Smith', 'janeS', 'jane.smith@example.com', '456 Oak St', 'img2.jpg', '123-456-7891', 1),
('user03', 'password3', 'Jim Brown', 'jimmy', 'jim.brown@example.com', '789 Pine St', 'img3.jpg', '123-456-7892', 1),
('user04', 'password4', 'Jake White', 'jakeW', 'jake.white@example.com', '321 Maple St', 'img4.jpg', '123-456-7893', 1),
('user05', 'password5', 'Lucy Black', 'lucyB', 'lucy.black@example.com', '654 Birch St', 'img5.jpg', '123-456-7894', 1),
('user06', 'password6', 'Lily Green', 'lilyG', 'lily.green@example.com', '987 Elm St', 'img6.jpg', '123-456-7895', 1),
('user07', 'password7', 'Max Blue', 'maxB', 'max.blue@example.com', '147 Cedar St', 'img7.jpg', '123-456-7896', 1),
('user08', 'password8', 'Emma Purple', 'emmaP', 'emma.purple@example.com', '258 Fir St', 'img8.jpg', '123-456-7897', 1),
('user09', 'password9', 'Oliver Yellow', 'oliverY', 'oliver.yellow@example.com', '369 Redwood St', 'img9.jpg', '123-456-7898', 1),
('user10', 'password10', 'Sophia Pink', 'sophiaP', 'sophia.pink@example.com', '741 Spruce St', 'img10.jpg', '123-456-7899', 1),
('user11', 'password11', 'Liam Red', 'liamR', 'liam.red@example.com', '852 Hemlock St', 'img11.jpg', '123-456-7900', 1),
('user12', 'password12', 'Mia Orange', 'miaO', 'mia.orange@example.com', '963 Cypress St', 'img12.jpg', '123-456-7901', 1),
('user13', 'password13', 'Noah Brown', 'noahB', 'noah.brown@example.com', '159 Juniper St', 'img13.jpg', '123-456-7902', 1),
('user14', 'password14', 'Isabella Gold', 'bellaG', 'bella.gold@example.com', '753 Aspen St', 'img14.jpg', '123-456-7903', 1),
('user15', 'password15', 'Mason Silver', 'masonS', 'mason.silver@example.com', '852 Alder St', 'img15.jpg', '123-456-7904', 1),
('user16', 'password16', 'Ethan Bronze', 'ethanB', 'ethan.bronze@example.com', '951 Poplar St', 'img16.jpg', '123-456-7905', 1),
('user17', 'password17', 'Ava Gray', 'avaG', 'ava.gray@example.com', '123 Cherry St', 'img17.jpg', '123-456-7906', 1),
('user18', 'password18', 'Logan Black', 'loganB', 'logan.black@example.com', '456 Willow St', 'img18.jpg', '123-456-7907', 1),
('user19', 'password19', 'Charlotte Pink', 'charlotteP', 'charlotte.pink@example.com', '789 Oak St', 'img19.jpg', '123-456-7908', 1),
('user20', 'password20', 'Elijah White', 'elijahW', 'elijah.white@example.com', '321 Maple St', 'img20.jpg', '123-456-7909', 1);

-- Group Table Dummy Data
INSERT INTO `suseok`.`Group` 
(`group_name`, `group_admin`, `goal_pace`, `goal_frequency`, `goal_total_distance`, `con_pace`, `con_frequency`, `con_total_distance`, `pace`, `frequency`, `total_distance`) 
VALUES
('Group01', 1, 6.5, 3, 15, 6.0, 2, 12, 5.8, 2, 10),
('Group02', 2, 7.0, 4, 20, 6.8, 3, 18, 6.5, 3, 15),
('Group03', 3, 5.5, 2, 10, 5.3, 2, 9, 5.0, 2, 8),
('Group04', 4, 8.0, 5, 25, 7.8, 4, 22, 7.5, 4, 20),
('Group05', 5, 6.0, 3, 12, 5.8, 2, 10, 5.5, 2, 9),
('Group06', 6, 7.5, 4, 22, 7.3, 3, 20, 7.0, 3, 18),
('Group07', 7, 6.5, 3, 15, 6.3, 2, 13, 6.0, 2, 12),
('Group08', 8, 8.5, 5, 28, 8.3, 4, 25, 8.0, 4, 23),
('Group09', 9, 5.0, 2, 8, 4.8, 1, 7, 4.5, 1, 6),
('Group10', 10, 7.0, 4, 20, 6.8, 3, 18, 6.5, 3, 15),
('Group11', 11, 6.5, 3, 15, 6.3, 2, 13, 6.0, 2, 12),
('Group12', 12, 8.0, 5, 25, 7.8, 4, 22, 7.5, 4, 20),
('Group13', 13, 6.0, 3, 12, 5.8, 2, 10, 5.5, 2, 9),
('Group14', 14, 7.5, 4, 22, 7.3, 3, 20, 7.0, 3, 18),
('Group15', 15, 6.5, 3, 15, 6.3, 2, 13, 6.0, 2, 12),
('Group16', 16, 8.5, 5, 28, 8.3, 4, 25, 8.0, 4, 23),
('Group17', 17, 5.0, 2, 8, 4.8, 1, 7, 4.5, 1, 6),
('Group18', 18, 7.0, 4, 20, 6.8, 3, 18, 6.5, 3, 15),
('Group19', 19, 6.5, 3, 15, 6.3, 2, 13, 6.0, 2, 12),
('Group20', 20, 8.0, 5, 25, 7.8, 4, 22, 7.5, 4, 20);

-- Group_member_info Table Dummy Data
INSERT INTO `suseok`.`Group_member_info` 
(`group_id`, `user_seq`) 
VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
(2, 6), (2, 7), (2, 8), (2, 9), (2, 10),
(3, 11), (3, 12), (3, 13), (3, 14), (3, 15),
(4, 16), (4, 17), (4, 18), (4, 19), (4, 20),
(5, 1), (5, 2), (5, 3), (5, 4), (5, 5),
(6, 6), (6, 7), (6, 8), (6, 9), (6, 10),
(7, 11), (7, 12), (7, 13), (7, 14), (7, 15),
(8, 16), (8, 17), (8, 18), (8, 19), (8, 20);

-- user_rank_record Table Dummy Data
INSERT INTO `suseok`.`user_rank_record` 
(`user_seq`, `frequency`, `total_distance`, `highest_pace`) 
VALUES
(1, 3, 15, 6.5),
(2, 4, 20, 7.0),
(3, 2, 10, 5.5),
(4, 5, 25, 8.0),
(5, 3, 12, 6.0),
(6, 4, 22, 7.5),
(7, 3, 15, 6.5),
(8, 5, 28, 8.5),
(9, 2, 8, 5.0),
(10, 4, 20, 7.0),
(11, 3, 15, 6.5),
(12, 5, 25, 8.0),
(13, 3, 12, 6.0),
(14, 4, 22, 7.5),
(15, 3, 15, 6.5),
(16, 5, 28, 8.5),
(17, 2, 8, 5.0),
(18, 4, 20, 7.0),
(19, 3, 15, 6.5),
(20, 5, 25, 8.0);

-- Rival_info Table Dummy Data
INSERT INTO `suseok`.`Rival_info` 
(`user_seq`, `rival_seq`) 
VALUES
(1, 2), (1, 3), (1, 4), (1, 5),
(2, 6), (2, 7), (2, 8), (2, 9),
(3, 10), (3, 11), (3, 12), (3, 13),
(4, 14), (4, 15), (4, 16), (4, 17),
(5, 18), (5, 19), (5, 20), (5, 1),
(6, 2), (6, 3), (6, 4), (6, 5),
(7, 6), (7, 7), (7, 8), (7, 9),
(8, 10), (8, 11), (8, 12), (8, 13),
(9, 14), (9, 15), (9, 16), (9, 17),
(10, 18), (10, 19), (10, 20), (10, 1);

-- board Table Dummy Data
INSERT INTO `suseok`.`board` 
(`group_id`, `writer_seq`, `title`, `content`, `img`, `notice`) 
VALUES
(1, 1, 'Title 1', 'Content 1', 'img1.jpg', 0),
(2, 2, 'Title 2', 'Content 2', 'img2.jpg', 0),
(3, 3, 'Title 3', 'Content 3', 'img3.jpg', 0),
(4, 4, 'Title 4', 'Content 4', 'img4.jpg', 0),
(5, 5, 'Title 5', 'Content 5', 'img5.jpg', 0),
(6, 6, 'Title 6', 'Content 6', 'img6.jpg', 0),
(7, 7, 'Title 7', 'Content 7', 'img7.jpg', 0),
(8, 8, 'Title 8', 'Content 8', 'img8.jpg', 0),
(9, 9, 'Title 9', 'Content 9', 'img9.jpg', 0),
(10, 10, 'Title 10', 'Content 10', 'img10.jpg', 0),
(11, 11, 'Title 11', 'Content 11', 'img11.jpg', 0),
(12, 12, 'Title 12', 'Content 12', 'img12.jpg', 0),
(13, 13, 'Title 13', 'Content 13', 'img13.jpg', 0),
(14, 14, 'Title 14', 'Content 14', 'img14.jpg', 0),
(15, 15, 'Title 15', 'Content 15', 'img15.jpg', 0),
(16, 16, 'Title 16', 'Content 16', 'img16.jpg', 0),
(17, 17, 'Title 17', 'Content 17', 'img17.jpg', 0),
(18, 18, 'Title 18', 'Content 18', 'img18.jpg', 0),
(19, 19, 'Title 19', 'Content 19', 'img19.jpg', 0),
(20, 20, 'Title 20', 'Content 20', 'img20.jpg', 0);

-- reply Table Dummy Data
INSERT INTO `suseok`.`reply` 
(`board_id`, `writer_seq`, `content`) 
VALUES
(1, 1, 'Reply 1'), (1, 2, 'Reply 2'), (1, 3, 'Reply 3'), (1, 4, 'Reply 4'), (1, 5, 'Reply 5'),
(2, 6, 'Reply 6'), (2, 7, 'Reply 7'), (2, 8, 'Reply 8'), (2, 9, 'Reply 9'), (2, 10, 'Reply 10'),
(3, 11, 'Reply 11'), (3, 12, 'Reply 12'), (3, 13, 'Reply 13'), (3, 14, 'Reply 14'), (3, 15, 'Reply 15'),
(4, 16, 'Reply 16'), (4, 17, 'Reply 17'), (4, 18, 'Reply 18'), (4, 19, 'Reply 19'), (4, 20, 'Reply 20'),
(5, 1, 'Reply 21'), (5, 2, 'Reply 22'), (5, 3, 'Reply 23'), (5, 4, 'Reply 24'), (5, 5, 'Reply 25'),
(6, 6, 'Reply 26'), (6, 7, 'Reply 27'), (6, 8, 'Reply 28'), (6, 9, 'Reply 29'), (6, 10, 'Reply 30'),
(7, 11, 'Reply 31'), (7, 12, 'Reply 32'), (7, 13, 'Reply 33'), (7, 14, 'Reply 34'), (7, 15, 'Reply 35'),
(8, 16, 'Reply 36'), (8, 17, 'Reply 37'), (8, 18, 'Reply 38'), (8, 19, 'Reply 39'), (8, 20, 'Reply 40');

select * from board;
select * from user;
select * from user_rank_record;
select * from `GROUP`;
select * from group_member_info;
select * from reply;
select * from rival_info;

