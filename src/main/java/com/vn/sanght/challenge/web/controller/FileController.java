package com.vn.sanght.challenge.web.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {
    private final Path audioPath = Paths.get("storages/audio");

    /**
     * GET /files/audio/{name} : Get audio file by name
     *
     * @param name  The name of audio file
     * @return found audio file
     * @throws FileNotFoundException if the audio file does not found
     */
    @GetMapping(path = "/audio/{name}", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<?> playAudio(@PathVariable("name") String name) throws FileNotFoundException {
        Path filePath = audioPath.resolve(name);
        File file = filePath.toFile();
        long length = file.length();

        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentLength(length);
        httpHeaders.setCacheControl(CacheControl.noCache().getHeaderValue());

        return new ResponseEntity<>(inputStreamResource, httpHeaders, HttpStatus.OK);
    }
}
