


http://media.test.vas.s3-website.eu-central-1.amazonaws.com/preview1.jpg


http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_1.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_3.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_4.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_5.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_6.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_7.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_8.jpg



http://media.test.vas.s3-website.eu-central-1.amazonaws.com/preview2.jpg

http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_0.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_1.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_2.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_3.jpg
http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_4.jpg








update brochure SET preview_url = 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/preview1.jpg' where id = 1;
update brochure SET preview_url = 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/preview2.jpg' where id = 2;
update brochure SET preview_url = 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/preview4.jpg' where id = 4;

INSERT into page VALUES  (10, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_1.jpg', 1);
INSERT into page VALUES  (11, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_3.jpg', 1);
INSERT into page VALUES  (12, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_4.jpg', 1);
INSERT into page VALUES  (13, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_5.jpg', 1);
INSERT into page VALUES  (14, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_6.jpg', 1);
INSERT into page VALUES  (15, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_7.jpg', 1);
INSERT into page VALUES  (16, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure1/page_8.jpg', 1);


INSERT into page VALUES  (20, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_0.jpg', 2);
INSERT into page VALUES  (21, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_1.jpg', 2);
INSERT into page VALUES  (22, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_2.jpg', 2);
INSERT into page VALUES  (23, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_3.jpg', 2);
INSERT into page VALUES  (24, 'simple title', 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/brochure2/page_4.jpg', 2);










-- 1 2 4
select * from brochure;

--5 6
select * from store;
select * from page;


select * from store_brochure;



update brochure SET preview_url = 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/preview1.jpg' where id = 1;
update brochure SET preview_url = 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/preview2.jpg' where id = 2;
update brochure SET preview_url = 'http://media.test.vas.s3-website.eu-central-1.amazonaws.com/preview4.jpg' where id = 4;



commit;





delete from store_brochure where brochure_id = 7 or brochure_id = 8 or brochure_id = 9 or brochure_id = 10;
delete from brochure where id = 7 or id = 8 or id = 9  or id = 10;

delete from page where id = 9;
delete from store where id = 11 or id = 12;

