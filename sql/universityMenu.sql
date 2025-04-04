-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大学信息', '3', '1', 'university', 'postgraduate/university/index', 1, 0, 'C', '0', '0', 'postgraduate:university:list', '#', 'admin', sysdate(), '', null, '大学信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大学信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'postgraduate:university:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大学信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'postgraduate:university:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大学信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'postgraduate:university:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大学信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'postgraduate:university:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('大学信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'postgraduate:university:export',       '#', 'admin', sysdate(), '', null, '');