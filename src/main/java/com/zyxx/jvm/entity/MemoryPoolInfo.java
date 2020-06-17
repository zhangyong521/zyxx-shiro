package com.zyxx.jvm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * vm各内存区信息
 *
 * @author Tellsea
 * @date 2020-6-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MemoryPoolInfo {

    private String poolName;
    private String poolMemoryManagerNames;
    private String poolObjectName;
    private long poolInit;
    private long poolMax;
    private long poolUsed;
    private long poolCommitted;
    private String poolUseRate;
}
