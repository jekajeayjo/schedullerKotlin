package md.scheduleServicekotlin.service

interface FileService {
    fun readFile(): String;
    fun readDataFromFile(fileName: String?): String
}