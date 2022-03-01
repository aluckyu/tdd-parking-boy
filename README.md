# tdd-parking-boy

### parking lot tasking
**Given** 有空闲停车位 **When** 停车  **Then** 停车成功 返回票据

**Given** 没有空闲停车 **When** 停车  **Then** 停车失败 提示停车场已满

**Given** 一张有效票据 **When** 取车 **Then** 取车成功

**Given** 一张伪造票据 **When** 取车 **Then** 取车失败，提示非法票据

**Given** 一张重复使用的票据 **When** 取车 **Then** 取车失败，提示非法票据