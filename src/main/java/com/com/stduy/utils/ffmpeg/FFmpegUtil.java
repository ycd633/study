package com.com.stduy.utils.ffmpeg;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import com.com.stduy.constants.DevConstants;

import java.io.File;
import java.io.IOException;

public class FFmpegUtil {

    public void thumbnail(String path) {

        Runtime run = Runtime.getRuntime();
        String videofile = path;
        String command = "C:\\Program Files\\ffmpeg\\bin\\ffmpeg.exe -i \"" + videofile + "\" -ss 00:00:10 -vcodec png -vframes 1 \""  +videofile + "_%2d.png\""; // 동영상 1초에서 Thumbnail 추출
        try{
            run.exec("cmd.exe chcp 65001");  // cmd에서 한글문제로 썸네일이 만들어지지않을시 cmd창에서 utf-8로 변환하는 명령
            run.exec(command);
        }catch(Exception e){
            System.out.println("error : "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void CreateTsAndThumbnail(String filePath, String jobId) throws IOException {
        FFmpeg ffmpeg = new FFmpeg(DevConstants.FFMPEG_PATH);
        FFprobe ffprobe = new FFprobe(DevConstants.FFPROBE_PATH);
        String TS_Path = DevConstants.TS_PATH+"/"+jobId;
        String PRE = DevConstants.PREVIEW_PATH+"/"+jobId;
        String fileTemp = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
        String fileName = fileTemp.substring(0, fileTemp.indexOf("."));

        File file = new File(TS_Path);
        if(!file.exists())
        {
            file.mkdir();
        }
        FFmpegBuilder builder = new FFmpegBuilder()
                //.overrideOutputFiles(true) // 오버라이드 여부
                .setInput(filePath) // 동영상파일
                .addOutput(TS_Path+ "/" + fileName +".m3u8") // 썸네일 경로
                .addExtraArgs("-profile:v", "baseline") //
                .addExtraArgs("-level", "3.0") //
                .addExtraArgs("-start_number", "0") //
                .addExtraArgs("-hls_time", "10") //
                .addExtraArgs("-hls_list_size", "0") //
                .addExtraArgs("-f", "hls") //
                .done();
        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder).run();


        FFmpegBuilder builderThumbNail = new FFmpegBuilder()
                .overrideOutputFiles(true) // 오버라이드 여부
                .setInput(filePath) // 동영상파일
                .addExtraArgs("-ss", "00:00:03") // 썸네일 추출 시점
                .addOutput(TS_Path + "/" + fileName+".png") // 썸네일 경로
                .setFrames(1) // 프레임 수
                .done();
        FFmpegExecutor executorThumbNail = new FFmpegExecutor(ffmpeg, ffprobe);
        executorThumbNail.createJob(builderThumbNail).run();


        FFmpegBuilder builderPreview = new FFmpegBuilder()
                .overrideOutputFiles(true) // 오버라이드 여부
                .setInput(filePath) // 동영상파일
                .addExtraArgs("-ss", "00:00:00") // 썸네일 추출 시점
                .addExtraArgs("-t", "00:00:10") // 썸네일 추출 시점
                .addOutput(PRE + "/" + fileName+".mp4") // 썸네일 경로
                .setFrames(1) // 프레임 수
                .done();
        FFmpegExecutor executorPreview = new FFmpegExecutor(ffmpeg, ffprobe);
        executorPreview.createJob(builderPreview).run();
    }
    public void ffmpegMetadata(String path) throws IOException {
        FFmpeg fFmpeg = new FFmpeg("C:\\Program Files\\ffmpeg\\bin\\ffmpeg.exe");
        FFprobe fFprobe = new FFprobe("C:\\Program Files\\ffmpeg\\bin\\ffprobe.exe");

        FFmpegProbeResult fFmpegProbeResult = fFprobe.probe(path);
        System.out.println(fFmpegProbeResult.getStreams().get(0).bit_rate);
        System.out.println(fFmpegProbeResult.getStreams().get(0).start_time);
        System.out.println(fFmpegProbeResult.getStreams().get(0).duration);
        System.out.println(fFmpegProbeResult.getStreams().get(0).duration_ts);
        System.out.println(fFmpegProbeResult.getStreams().get(0).time_base);

        int min, sec,hour;


        sec = (int)fFmpegProbeResult.getStreams().get(0).duration;
        min = sec / 60;
        hour = min / 60;
        sec = sec % 60;
        min = min % 60;
        System.out.printf("%d시 %d분 %d초", hour, min, sec);
    }

}
