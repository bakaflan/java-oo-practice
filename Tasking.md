添加新热搜
* Given 需要向热搜排行添加一个新热搜
* When 向排行中添加热搜
* Then 能在热搜排行中查看所有热搜排名，查看新添加热搜的排行

添加一个已有热搜
* Given 需要向热搜排行添加一个已经存在的热搜（根据描述判断）
* When 向排行中添加热搜
* Then 提示该热搜已被添加

给热搜投票
* Given 给热搜投票增加热度
* When 修改热搜的热度
* Then 更新排行，更新热搜热度

用户登录
* Given 用户需要选择身份进行登录
* When 用户选择普通用户/管理员
* Then 提示用户当前身份

用户投票
* Given 用户给热搜投票增加热度 
* When 用户选择给某一热搜投票
* Then 修改用户剩余票数，更新热搜排行，更新热搜热度

用户投票超出剩余票数
* Given 用户给热搜投票增加热度 
* When 用户选择给某一热搜投票，投票数超过剩余票数
* Then 提示用户剩余票数不足，请重新输入

购买热搜
* Given 用户为热搜购买热搜
* When 用户选择给某一热搜进行购买，输入金额
* Then 删除原位置热搜，调整排行，显示金额

添加超级热搜
* Given 管理员添加超级热搜
* When 用户对超级热搜进行投票
* Then 热度增加两倍



