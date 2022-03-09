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