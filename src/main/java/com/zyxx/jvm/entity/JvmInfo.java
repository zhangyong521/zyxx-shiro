package com.zyxx.jvm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.management.ObjectName;
import java.lang.management.ThreadInfo;
import java.util.List;
import java.util.Map;

/**
 * jvm 信息
 *
 * @author Tellsea
 * @date 2020-6-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class JvmInfo {

    /**
     * 系统信息
     */
    private String systemName;
    private String systemVersion;
    private String systemArch;
    private int systemAvailableProcessors;
    private long totalPhysicalMemory;
    private long freePhysicalMemory;
    private long usedPhysicalMemorySize;
    private long totalSwapSpaceSize;
    private long freeSwapSpaceSize;
    private long usedSwapSpaceSize;
    /**
     * 编译信息
     */
    private String compilationName;
    private String compilationTotalCompilationTime;
    /**
     * 类加载信息
     */
    private long classLoadTotalLoadedClassCount;
    private long classLoadLoadedClassCount;
    private long classLoadUnloadedClassCount;
    /**
     * 运行时信息
     */
    private String runtimeName;
    private String runtimeSpecName;
    private String runtimeSpecVendor;
    private String runtimeSpecVersion;
    private long runtimeStartTime;
    private Map<String, String> runtimeSystemProperties;
    private long runtimeUptime;
    private String runtimeVmName;
    private String runtimeVmVendor;
    private String runtimeVmVersion;
    private List<String> runtimeInputArguments;
    private String runtimeClassPath;
    private String runtimeBootClassPath;
    private String runtimeLibraryPath;
    /**
     * vm内存管理器
     */
    private List<MemoryManagerInfo> memoryManagerInfos;
    /**
     * 垃圾收集器
     */
    private List<GarbageCollectorInfo> garbageCollectorInfos;
    /**
     * vm内存信息
     */
    private long headMemoryInit;
    private long headMemoryMax;
    private long headMemoryUsed;
    private long headMemoryCommitted;
    private String headMemoryUseRate;
    private long nonheadMemoryInit;
    private long nonheadMemoryMax;
    private long nonheadMemoryUsed;
    private long nonheadMemoryCommitted;
    private String nonheadMemoryUseRate;
    /**
     * vm各内存区信息
     */
    private List<MemoryPoolInfo> memoryPoolInfos;
    /**
     * 线程信息
     */
    private ObjectName threadObjectName;
    private int threadThreadCount;
    private int threadPeakThreadCount;
    private long threadTotalStartedThreadCount;
    private int threadDaemonThreadCount;
    private ThreadInfo[] deadlockThreadInfos;
    private ThreadInfo[] threadInfos;
}
