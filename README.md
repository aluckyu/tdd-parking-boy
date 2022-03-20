# tdd-parking-boy

### parking lot tasking
停车场可以停车、取车

**Given** 有空闲停车位 **When** 停车  **Then** 停车成功 返回票据

**Given** 没有空闲停车位 **When** 停车  **Then** 停车失败 提示停车场已满

**Given** 一张有效票据 **When** 取车 **Then** 取车成功

**Given** 一张伪造票据 **When** 取车 **Then** 取车失败，提示非法票据

**Given** 一张重复使用的票据 **When** 取车 **Then** 取车失败，提示非法票据

### parking boy tasking
作为一个初入职场的停车小弟，我能将车顺序停放到多个停车场，并可以取出

**Given** parking boy管理两个停车场，两个停车场都有可用容量 
**When** parking boy停车
**Then** 成功停入第一个停车场，返回票据

**Given** parking boy管理两个停车场，第一个停车场已经停满，第二个停车场有可用容量
**When** parking boy停车
**Then** 成功停入第二个停车场，返回票据

**Given** parking boy管理两个停车场，两个停车场都没有可用容量
**When** parking boy停车
**Then** 停车失败，提示停车场已满

**Given** parking boy管理两个停车场，拿到一张有效的票
**When** parking boy取车
**Then** 取车成功

**Given** parking boy管理两个停车场，拿到一张伪造的票
**When** parking boy取车
**Then** 取车失败，提示非法票据

### smart parking boy
作为一个聪明的停车小弟，我能将车停在空车位最多的那个停车场，并可以取出

**Given** smart parking boy管理两个停车场，第一个停车场剩余车位为3，第二个停车场剩余车位为2
**When** 停车
**Then** 成功存入第一个停车场，返回票据

**Given** smart parking boy管理两个停车场，第一个停车场剩余车位为2，第二个停车场剩余车位为3
**When** 停车
**Then** 成功存入第二个停车场，返回票据

**Given** smart parking boy管理两个停车场，2个停车场剩余车位都为2
**When** 停车
**Then** 成功存入第一个停车场，返回票据

**Given** smart parking boy管理两个停车场，拿到一张有效的票
**When** 取车
**Then** 取车成功

**Given** smart parking boy管理两个停车场，拿到一张伪造的票
**When** 取车
**Then** 取车失败，提示非法票据

### parking Manager
作为停车场经理，我要管理多个停车仔，我可以让停车仔停车，也可以自己停车

需求澄清：
 - Parking Manager自己存的车只能自己取
 - Parking Manager只能取自己停的车
 - Parking Manager手下可能有多个停车仔，也可能没有停车仔
 - Parking Manager管理的停车场是按照顺序存车的
 - Parking Manager管理的停车场和他手下停车仔管理的停车场不重合

**Given** parking manager不管理停车仔，自己管理2个停车场，2个停车场都有空位
**When** 停车
**Then** 停车到第1个车场成功，返回票据

**Given** parking manager不管理停车仔，自己管理2个停车场，第1个停车场已满，第2个有空位
**When** 停车
**Then** 停车到第2个车场成功，返回票据

**Given** parking manager不管理停车仔，自己管理2个停车场，2个停车场都已满
**When** 停车
**Then** 停车失败，提示停车场已满

**Given** parking manager管理2个停车仔，自己不管理停车场，2个停车仔的停车场都有空位
**When** 停车
**Then** 第1个停车仔停车成功，返回票据

**Given** parking manager管理2个停车仔，自己不管理停车场，第1个停车仔已满，第2个停车仔有空位
**When** 停车
**Then** 第2个停车仔停车成功，返回票据

**Given** parking manager管理2个停车仔，自己不管理停车场，2个停车仔的停车场都已满
**When** 停车
**Then** 存车失败，提示停车场已满

**Given** parking manager管理1个停车仔，自己管理1个停车场，自己和停车仔的停车场都有空位
**When** 停车
**Then** 停车到自己管理的停车场成功，返回票据

**Given** parking manager管理1个停车仔，自己管理1个停车场，自己的停车场已满，停车仔的停车场有空位
**When** 停车
**Then** 停车到停车仔车场成功，返回票据

**Given** parking manager管理1个停车仔，自己管理1个停车场，自己和停车仔的停车场都已满
**When** 停车
**Then** 停车失败，提示停车场已满

**Given** parking manager不管理停车仔，自己管理2个停车场  
**When** 用合法的停车票据取车  
**Then** 取车成功

**Given** parking manager不管理停车仔，自己管理2个停车场  
**When** 用不合法的停车票据取车  
**Then** 取车失败，提示票据非法

**Given** parking manager管理2个停车仔，自己不管理停车场  
**When** 用合法的停车票据取车  
**Then** 取车成功

**Given** parking manager管理2个停车仔，自己不管理停车场  
**When** 用不合法的停车票据取车  
**Then** 取车失败，提示票据非法

**Given** parking manager管理1个停车仔，自己管理1个停车场  
**When** 用合法的停车票据取车  
**Then** 取车成功

**Given** parking manager管理1个停车仔，自己管理1个停车场  
**When** 用不合法的停车票据取车  
**Then** 取车失败，提示票据非法
