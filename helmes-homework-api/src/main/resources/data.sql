-- H2 2.2.224;
;
CREATE USER IF NOT EXISTS "SA" SALT '11cd47814cdf43fe' HASH 'fbb629983adec60ae8b43850806961c77f86321d6fc841136a3fd2eb46e1b2be' ADMIN;
CREATE SEQUENCE "PUBLIC"."SECTOR_SEQ" START WITH 1 RESTART WITH 151 INCREMENT BY 50;
CREATE SEQUENCE "PUBLIC"."USER_DATA_SEQ" START WITH 1 INCREMENT BY 50;
CREATE MEMORY TABLE "PUBLIC"."SECTOR"(
    "ID" BIGINT NOT NULL,
    "PARENT_ID" BIGINT,
    "NAME" CHARACTER VARYING(255) NOT NULL,
    "SECTOR_ID" CHARACTER VARYING(255),
    "DEPTH" INT NOT NULL
);
ALTER TABLE "PUBLIC"."SECTOR" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_91" PRIMARY KEY("ID");
-- 79 +/- SELECT COUNT(*) FROM PUBLIC.SECTOR;
INSERT INTO "PUBLIC"."SECTOR" VALUES
(1, null, 'Manufacturing', '0d24b1d0-51b2-48ed-8067-20fe742c8f19', 0),
(2, 1, 'Construction materials', '570800c5-b1d1-4cad-99d7-405d6d8fa2d7', 1),
(3, 1, 'Electronics and Optics', '896438e1-2303-44de-801d-f6006a2d7436', 1),
(4, 1, 'Food and Beverage', 'f00f5ece-ac34-48f3-bd07-6c54416c5aa9', 1),
(5, 4, 'Bakery & confectionery products', '7b70a537-c6be-43fb-9193-d8ebf9427e1f', 2),
(6, 4, 'Beverages', '70c52ca9-651a-41e5-bf12-504141a783ef', 2),
(7, 4, 'Fish & fish products', '8d2c31d3-3629-4e0a-a3ea-d27d23c8d2b8', 2),
(8, 4, 'Meat & meat products', 'b56160ac-1f68-4956-bfbc-6bf880aad44e', 2),
(9, 4, 'Milk & dairy products', 'fdef0e8e-5868-49d9-9bcc-887ad8218502', 2),
(10, 4, 'Other', '3a99b76e-ef89-4892-833c-d114285b3243', 2),
(11, 4, 'Sweets & snack food', '2c9051ed-700d-4b05-9fd7-8e18f2a4667f', 2),
(12, 1, 'Furniture', 'ed486340-17bc-4412-8d48-e7e1843cf734', 1),
(13, 12, 'Bathroom/sauna', 'd37ea8c5-8b9f-4913-b685-56a278dcb3aa', 2),
(14, 12, 'Bedroom', '6fc5a332-3d40-4254-b3a0-dce199bea28f', 2),
(15, 12, U&'Children\2019s room', 'ca7a962a-ffab-4a0e-866b-b0e92388abc3', 2),
(16, 12, 'Kitchen', 'bbaa0ecb-bdd0-4ef5-8e11-48aaafd60e04', 2),
(17, 12, 'Living room', 'a0030ada-397a-4ae4-83a5-d07ef204a2e1', 2),
(18, 12, 'Office', '51723488-00cc-49d3-ad20-a0ea72653270',2 ),
(19, 12, 'Other (Furniture)', '2490f3cd-dd96-4c6b-a213-7fee91c24404', 2),
(20, 12, 'Outdoor', '68423616-9a57-4d25-a3ed-9f86a1c6fd03', 2),
(21, 12, 'Project furniture', 'ac2ee0b9-90fa-4baf-8d30-ccbedddb1bcc', 2),
(22, 1, 'Machinery', 'ce04ab8f-e7c0-47b8-a10f-28e8cd3e7a26', 1),
(23, 22, 'Machinery components', 'e27a0ed3-1c44-4b65-a670-0ddd7d40bece', 2),
(24, 22, 'Machinery equipment/tools', 'bd67cd99-8160-4d45-a457-4f7a1f873ae4', 2),
(25, 22, 'Manufacture of machinery', '0d12025d-1262-4e6c-85c0-94cce98df024', 2),
(26, 22, 'Maritime', 'e7d79577-4719-4df3-9508-09c71daa58db', 2),
(27, 26, 'Aluminium and steel workboats', 'c69048da-a660-4fbc-9686-e0e0dfd972ae', 3),
(28, 26, 'Boat/Yacht building', 'f4bd0a55-da72-4ad1-8aec-6174b55056a9', 3),
(29, 26, 'Ship repair and conversion', 'acf8cd7c-dbd3-4de2-845b-ade938a6d612', 3),
(30, 22, 'Metal structures', '02b8435c-8b27-4916-ba3e-025c8774f968', 2),
(31, 22, 'Other', '8b9efe65-8ea3-4c16-b5c5-68f531aa5ebb', 2),
(32, 22, 'Repair and maintenance service', 'b909a51d-440a-4d9c-858e-4e2982cc093e', 2),
(33, 1, 'Metalworking', 'e1b2584f-1afe-442a-98b8-f42f92283848', 1),
(34, 33, 'Construction of metal structures', 'dd5a92ed-69a2-4744-9f35-1ebd34f816fa', 2),
(35, 33, 'Houses and buildings', '2235b169-e175-4396-93dc-bd2dee412f67', 2),
(36, 33, 'Metal products', 'c3838f36-f61b-4d9e-bd3b-f16193c0c6d2', 2),
(37, 33, 'Metal works', 'b950d90d-23e5-4562-9370-2d07fdbc6569', 2),
(38, 37, 'CNC-machining', 'bb891829-682a-4cbc-aa55-2ebd46cc9248', 3),
(39, 37, 'Forgings, Fasteners', 'aa5fb09d-cde9-4de0-a7da-87290c49151e', 3),
(40, 37, 'Gas, Plasma, Laser cutting', '0a53412d-2d21-4bdf-b214-43c886efa03b', 3),
(41, 37, 'MIG, TIG, Aluminum welding', '5a5621b2-3b15-4277-9b15-38462b365e3b', 3),
(42, 1, 'Plastic and Rubber', '6f68cf45-f01d-4818-8cce-c7c0375263f7', 1),
(43, 42, 'Packaging', '2da7f13e-0a3f-4516-b0f2-e5ae408fe2ca', 2),
(44, 42, 'Plastic goods', '0c32bd3e-4f55-4c40-b88b-c05d58951b39', 2),
(45, 42, 'Plastic processing technology', '20248dc4-b200-4c5e-a606-e5e3066f126d', 2),
(46, 45, 'Blowing', 'ecb668f7-0ac5-481e-b720-53889bb6050e', 3),
(47, 45, 'Moulding', 'ac29e81d-42c5-4144-960a-eac0af54277b', 3),
(48, 45, 'Plastics welding and processing', '051955f1-b3d3-456b-9082-ac8ffdbd275a', 3),
(49, 42, 'Plastic profiles', '3c3f7037-8d18-4eb6-b35c-957b70e88cf6', 2),
(50, 1, 'Printing', '532de1b0-f27b-4bb1-805c-e7b44f247658', 1),
(51, 50, 'Advertising', '9ad1ca31-8497-4d8e-b2ac-95d206be85ea', 2),
(52, 50, 'Book/Periodicals', 'af1fa5f6-aa26-4330-b9c9-533afbc9da71', 2),
(53, 50, 'Labelling and packaging printing', 'deef8749-5c31-41a4-bf5a-686f51a258f6', 2),
(54, 1, 'Textile and Clothing', '6f361622-c823-4118-8b8b-cbd58d745d4f', 1),
(55, 54, 'Clothing', 'f4fedca2-1b32-4517-845d-18334365ed60', 2),
(56, 54, 'Textile', '4d753486-f8c0-4f16-8b45-adf58b4abcf6', 2),
(57, 1, 'Wood', '4aa7ed07-2981-440e-bb44-4e2693a4b48e', 1),
(58, 57, 'Other (Wood)', '68a1702d-9932-4cef-9ed9-cb388b422a5e', 2),
(59, 57, 'Wooden building materials', '3df1940a-bfb3-4101-9878-0c9cb73818f7', 2);
INSERT INTO "PUBLIC"."SECTOR" VALUES
(60, 57, 'Wooden houses', 'c3bb8c58-9719-4fe5-922f-0f89ae3e8064', 2),
(61, null, 'Other', '8efb07e3-23c2-4f84-ba7d-0eddbcfc6878', 0),
(62, 61, 'Creative industries', 'd4c51c6d-4147-4c10-9421-4ce655f0b8d7', 1),
(63, 61, 'Energy technology', '2d21b236-f883-4bfe-85de-8e69cede1a71', 1),
(64, 61, 'Environment', 'f9fc9ceb-f3ef-419e-88f3-50f309010b48', 1),
(65, null, 'Service', '17fc01d3-7c99-4fc6-bad1-71cf272a06fd', 0),
(66, 65, 'Business services', '4555f739-4e22-4911-9971-a3fb5db07b89', 1),
(67, 65, 'Engineering', 'dc7f12e2-0cf4-4e07-ad40-00bdbfcfa37b', 1),
(68, 65, 'Information Technology and Telecommunications', '1e4d74f2-751e-43af-8ccc-2fe32b3c2096', 1),
(69, 68, 'Data processing, Web portals, E-marketing', '9fda0b34-61ea-4c8e-aea0-261f8f1a2fb3', 2),
(70, 68, 'Programming, Consultancy', '15a4feec-a319-4a9a-b653-7c0d1025ab2b', 2),
(71, 68, 'Software, Hardware', 'd5d37807-528d-4911-848d-75da6118fda1', 2),
(72, 68, 'Telecommunications', '6c7bfd5c-ccd6-4859-ac87-8c4ae2edcb71', 2),
(73, 65, 'Tourism', 'aa80af97-ab13-47bf-9715-58fbf4bb2a4a', 1),
(74, 65, 'Translation services', '6db3fef4-fa87-44c4-86d0-21fa70284230', 1),
(75, 65, 'Transport and Logistics', '16acd2b6-f9f6-4d44-90f3-1fd7442088fa', 1),
(76, 75, 'Air', 'b26df440-d2a6-4825-91b2-06d9fe3733ba', 2),
(77, 75, 'Rail', 'b01c4ca7-5ec0-4b37-ba0c-7a2f9a16ce77', 2),
(78, 75, 'Road', '5339f286-8719-452d-976b-5eb8dc74d57b', 2),
(79, 75, 'Water', '05e9740f-da6b-45d1-8623-468563228c49', 2);
CREATE MEMORY TABLE "PUBLIC"."USER_DATA"(
    "TERMS_AGREED" BOOLEAN NOT NULL,
    "ID" BIGINT NOT NULL,
    "USER_ID" CHARACTER VARYING(255) NOT NULL,
    "NAME" CHARACTER VARYING(255) NOT NULL
);
ALTER TABLE "PUBLIC"."USER_DATA" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_B" PRIMARY KEY("ID");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.USER_DATA;
CREATE MEMORY TABLE "PUBLIC"."USER_SECTOR"(
    "SECTOR_ID" BIGINT NOT NULL,
    "USER_ID" BIGINT NOT NULL
);
ALTER TABLE "PUBLIC"."USER_SECTOR" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("SECTOR_ID", "USER_ID");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.USER_SECTOR;
ALTER TABLE "PUBLIC"."SECTOR" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" UNIQUE("SECTOR_ID");
ALTER TABLE "PUBLIC"."USER_SECTOR" ADD CONSTRAINT "PUBLIC"."FKII0AXT4AKR7XRQC09BO44OL5K" FOREIGN KEY("USER_ID") REFERENCES "PUBLIC"."USER_DATA"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."USER_SECTOR" ADD CONSTRAINT "PUBLIC"."FKAJJTOC3NWPA9DHCY720G3BGXS" FOREIGN KEY("SECTOR_ID") REFERENCES "PUBLIC"."SECTOR"("ID") NOCHECK;
