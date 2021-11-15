create table if not exists file
(
    id           bigint       not null auto_increment,
    created_date datetime(6),
    file_bytes   LONGBLOB,
    name         varchar(255) not null,
    size         bigint       not null,
    user_id      bigint,
    primary key (id)
) engine = InnoDB;

create table if not exists user
(
    id         bigint       not null auto_increment,
    email      varchar(255),
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    password   varchar(3000),
    username   varchar(255),
    primary key (id)
) engine = InnoDB;

create table if not exists user_role
(
    user_id bigint not null,
    roles   integer
) engine = InnoDB;

alter table user
    add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table user
    add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table file
    add constraint FKinph5hu8ryc97hbs75ym9sm7t foreign key (user_id) references user (id);
alter table user_role
    add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);