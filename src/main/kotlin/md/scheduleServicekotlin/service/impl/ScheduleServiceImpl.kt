package md.scheduleServicekotlin.service.impl

import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import md.scheduleServicekotlin.entity.PaymentEntity
import md.scheduleServicekotlin.repository.PaymentRepository
import md.scheduleServicekotlin.service.FileService
import md.scheduleServicekotlin.service.ModelMapperService
import md.scheduleServicekotlin.service.ScheduleService
import org.apache.logging.log4j.LogManager
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.concurrent.Executors
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Service
@EnableScheduling
class ScheduleServiceImpl : ScheduleService {
    val gson = Gson()
    private val logger = LoggerFactory.getLogger(this.javaClass)
    @Autowired
    lateinit var fileService: FileService;
    @Autowired
    lateinit var modelMapperService: ModelMapperService;
    @Autowired
    lateinit var paymentRepository: PaymentRepository;



    @Scheduled(fixedRate = 60000)
    override fun scheduleSync() {
        logger.info("start sync")
        val executor = Executors.newCachedThreadPool();

        for (bid in modelMapperService.fromStringToList(fileService.readFile())) {
            var map = bid as Map<*, *>

            for ((key, value) in map) {
                executor.submit(Runnable {
                    println("start thread")
                    logger.info("start thread pool")
                    var paymentEntity: PaymentEntity = modelMapperService.FromMapToEntity(value as Map<String, String>);
                    paymentRepository.save(paymentEntity);
                });

            }
        }


    }

}

