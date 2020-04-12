create user  'cloud'@'%'  IDENTIFIED  by 'root';

create DATABASE  `oauth-center` ;
create DATABASE  `user-center` ;

grant  all  PRIVILEGES  on  `user-center`.* to   'cloud'@'%' ;
grant  all  PRIVILEGES  on  `oauth-center`.* to   'cloud'@'%' ;


flush privileges ;