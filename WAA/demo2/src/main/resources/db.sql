INSERT INTO course (course_id, name) VALUES
                                         (1, 'Mathematics'),
                                         (2, 'Physics'),
                                         (3, 'Chemistry'),
                                         (4, 'Biology'),
                                         (5, 'Computer Science');

INSERT INTO address (address_id, city, state, zipcode) VALUES
                                                                    (1, 'Springfield', 'IL', '62704'),
                                                                    (2, 'Lincoln', 'NE', '68508'),
                                                                    (3, 'Madison', 'WI', '53703'),
                                                                    (4,  'Columbus', 'OH', '43215'),
                                                                    (5, 'Austin', 'TX', '73301');
INSERT INTO student (student_id, name, gpa, address_id) VALUES
                                                            (1, 'John Doe', 3.5, 1),
                                                            (2, 'Jane Smith', 3.8, 2),
                                                            (3, 'Michael Johnson', 3.6, 3),
                                                            (4, 'Emily Davis', 3.9, 4),
                                                            (5, 'Daniel Brown', 3.7, 5);
INSERT INTO course_details (description_id, course_description, credit, program, last_update, course_id) VALUES
                                                                                                             (1, 'Introductory Mathematics Course', 3, 'Mathematics', '2023-01-01', 1),
                                                                                                             (2, 'Advanced Physics Topics', 4, 'Physics', '2023-02-01', 2),
                                                                                                             (3, 'Basics of Chemistry', 3, 'Chemistry', '2023-03-01', 3),
                                                                                                             (4, 'Fundamentals of Biology', 4, 'Biology', '2023-04-01', 4),
                                                                                                             (5, 'Introduction to Computer Science', 3, 'Computer Science', '2023-05-01', 5);
INSERT INTO student_course (student_id, course_id) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 2),
                                                       (2, 3),
                                                       (3, 3),
                                                       (3, 4),
                                                       (4, 4),
                                                       (4, 5),
                                                       (5, 5),
                                                       (5, 1);
