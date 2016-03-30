-- ע���û����
create table table_user(
	id integer primary key,
	username varchar2(20) unique,
	nickname varchar2(20),
	password varchar2(32),
	locked number(1) check(locked in(0,1))
);

create sequence  sqce_user start with 100;

insert into table_user values(sqce_user.nextval,'TestUser','TestUserDemo','test',1);

-- ��ϵ�˱�
					--<th>����</th>
					--<th>����</th>
					--<th>����</th>
					--<th>�绰����</th>
					--<th>�ʱ�</th>
create table table_contact(
	id integer primary key,
	name varchar2(50),
	birthday date,
	age number(3),
	phone varchar2(12),
	zipcode varchar2(6)
);
--oracle �����ú��� to_date();
create sequence sequence_contact start with 10000;

insert into table_contact values (sequence_contact.nextval,'daodao',sysdate,20,'13027783160','476400');
commit;

--ɾ����������� drop��ɾ���ͺ�;

-- ��ѯ�����û� 
select * from table_user;

--