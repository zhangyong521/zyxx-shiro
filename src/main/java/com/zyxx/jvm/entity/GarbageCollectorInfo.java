package com.zyxx.jvm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 垃圾收集器
 *
 * @author Tellsea
 * @date 2020-6-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class GarbageCollectorInfo {

    private String garbageName;
    private long garbageCollectionCount;
    private long garbageCollectionTime;
    private String garbageMemoryPoolNames;
}
