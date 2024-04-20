
create table directory_country_region
(
    region_id    int          not null
        primary key,
    code         varchar(255) null,
    default_name varchar(255) null,
    country_id   varchar(255) null
);

create index DIRECTORY_COUNTRY_REGION_COUNTRY_ID
    on directory_country_region (country_id);

INSERT INTO directory_country_region (region_id, code, default_name, country_id) VALUES (1, 'NY', 'New York', 'US');
INSERT INTO directory_country_region (region_id, code, default_name, country_id) VALUES (2, 'CA', 'California', 'US');
