# 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
#
# 示例：
#
# +----+---------+
# | Id | Email   |
# +----+---------+
# | 1  | a@b.com |
# | 2  | c@d.com |
# | 3  | a@b.com |
# +----+---------+
# 根据以上输入，你的查询应返回以下结果：
#
# +---------+
# | Email   |
# +---------+
# | a@b.com |
# +---------+
# 说明：所有电子邮箱都是小写字母。

#  356  449
SELECT `EMAIL` FROM Person GROUP BY `EMAIL` HAVING COUNT(*) > 1;
#  697  1008
SELECT DISTINCT A.EMAIL FROM Person A, Person B WHERE A.EMAIL = B.EMAIL AND A.ID != B.ID
