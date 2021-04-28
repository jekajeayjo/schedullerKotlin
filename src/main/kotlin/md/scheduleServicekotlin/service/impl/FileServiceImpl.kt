package md.scheduleServicekotlin.service.impl

import md.scheduleServicekotlin.service.FileService
import java.util.*
import org.apache.logging.log4j.LogManager
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File
import java.lang.Exception
@Service("testFile")
class FileServiceImpl : FileService {
    private val properties: Properties = Properties()
    var pathFile: String? = null;
    private val logger = LogManager.getLogger(FileServiceImpl::class.java)
    var log = LoggerFactory.getLogger(FileServiceImpl::class.java);
    init {
        logger.info("start init");
        val props  = javaClass.classLoader.getResourceAsStream("application.properties").use {
            Properties().apply { load(it) }
        }
        pathFile=props.getProperty("file.path");

    }
     override fun readDataFromFile(fileName: String?): String
            = File(fileName).readText(Charsets.UTF_8)
    override fun readFile(): String {

        log.info("start")
        log.debug("Start read data from File debug")
        log.trace("start")
        var st=pathFile;
        try {
            return readDataFromFile(st);
        }
        catch (e:Exception)
        {
            logger.error("Exception "+e)
            println(e)
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


    }
}