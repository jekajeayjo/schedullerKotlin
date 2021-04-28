package md.scheduleServicekotlin.service.impl

import md.scheduleServicekotlin.service.FileService
import java.util.*
import org.apache.logging.log4j.LogManager
import org.slf4j.*
import org.springframework.stereotype.Service
import java.io.File
import java.lang.Exception
@Service("testFile")
class FileServiceImpl : FileService {
    private val properties: Properties = Properties()
    var pathFile: String? = null;
    private val logger = LogManager.getLogger(FileServiceImpl::class.java)
    private val log = LoggerFactory.getLogger(this.javaClass)
    init {
        log.debug("Start init debug")
        val props  = javaClass.classLoader.getResourceAsStream("application.properties").use {
            Properties().apply { load(it) }
        }
        pathFile=props.getProperty("file.path");

    }
     override fun readDataFromFile(fileName: String?): String
            = File(fileName).readText(Charsets.UTF_8)
    override fun readFile(): String {
        log.debug("Start read data from File debug")
        var st=pathFile;
        try {
            return readDataFromFile(st);
        }
        catch (e:Exception)
        {
            logger.error("Exception "+e);
            log.error("Exception "+e);
            println(e)
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


    }
}