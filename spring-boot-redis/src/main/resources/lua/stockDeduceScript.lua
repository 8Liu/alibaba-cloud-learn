-- 返回值
--0: 成功
--1: 库存键不存在
--2：库存不足
local key = KEYS[1]
local stock = redis.call('get', key);
if not stock then -- 库存键不存在。键termStock:XXX
    return 1;
else
    if tonumber(stock) < tonumber(ARGV[1]) then -- 库存少于要购买的数量
        return 2;
    end;
end;
-- 扣减
redis.call('decrBy', key, ARGV[1]);
-- 若无异常，则返回0
return 0 ;