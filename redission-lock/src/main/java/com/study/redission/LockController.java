package com.study.redission;


import com.study.common.core.lock.redission.RedissonLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 不基于注解方式锁操作
 *
 * @date 2019/6/19 下午6:01
 */
@RestController
@Slf4j
public class LockController {

    @Autowired
    RedissonLock redissonLock;

    /**
     * 模拟这个是商品库存
     */
    public static volatile Integer TOTAL = 10;


    @GetMapping("lock-decrease-stock")
    public String lockDecreaseStock() throws InterruptedException {
        redissonLock.lock("lock", 10L);
        if (TOTAL > 0) {
            TOTAL--;
        }
        Thread.sleep(50);
        log.info("===lock===减完库存后,当前库存===" + TOTAL);
        //如果该线程还持有该锁，那么释放该锁。如果该线程不持有该锁，说明该线程的锁已到过期时间，自动释放锁
        if (redissonLock.isHeldByCurrentThread("lock")) {
            redissonLock.unlock("lock");
        }
        return "=================================";
    }

    @GetMapping("trylock-decrease-stock")
    public String trylockDecreaseStock() throws InterruptedException {
        if (redissonLock.tryLock("trylock", 5L, 200L)) {
            if (TOTAL > 0) {
                TOTAL--;
            }
            Thread.sleep(50);
            redissonLock.unlock("trylock");
            log.info("====tryLock===减完库存后,当前库存===" + TOTAL);
        } else {
            log.info("[ExecutorRedisson]获取锁失败");
        }
        return "===================================";
    }


    @GetMapping("trylock-decrease-stock")
    public String trylock() throws InterruptedException {
        log.info("[开始]执行RedisLock环绕通知,获取Redis分布式锁开始");
        //获取锁名称

        //获取超时时间，默认10秒
        redissonLock.lock("hahaLock", 1);
        try {
            log.info("获取Redis分布式锁[成功]，加锁完成，开始执行业务逻辑...");
        } catch (Throwable throwable) {
            log.error("获取Redis分布式锁[异常]，加锁失败", throwable);
            throwable.printStackTrace();
        } finally {
            //如果该线程还持有该锁，那么释放该锁。如果该线程不持有该锁，说明该线程的锁已到过期时间，自动释放锁
            if (redissonLock.isHeldByCurrentThread("hahaLock")) {
                redissonLock.unlock("lockName");
            }
        }
        log.info("释放Redis分布式锁[成功]，解锁完成，结束业务逻辑...");
        return  "";
    }




}
