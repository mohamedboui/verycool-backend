CREATE TABLE public.tag (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(255)
);
CREATE TABLE public.idea (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    description varchar(255),
    title varchar(255)
);
CREATE TABLE public.idea_tags (
    idea_id BIGINT NOT NULL,
    tag_id BIGINT NOT NULL
);

ALTER TABLE public.idea_tags OWNER TO mangopayuser;
ALTER TABLE public.idea OWNER TO mangopayuser;
ALTER TABLE public.tag OWNER TO mangopayuser;

ALTER TABLE ONLY public.tag
    ADD CONSTRAINT tag_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.idea
    ADD CONSTRAINT idea_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.idea_tags
    ADD CONSTRAINT idea_tags_pkey PRIMARY KEY (idea_id, tag_id);

ALTER TABLE ONLY public.idea_tags
    ADD CONSTRAINT fk_idea_tags_idea FOREIGN KEY (idea_id) REFERENCES public.idea(id);

ALTER TABLE ONLY public.idea_tags
    ADD CONSTRAINT fk_idea_tags_tag FOREIGN KEY (tag_id) REFERENCES public.tag(id);

