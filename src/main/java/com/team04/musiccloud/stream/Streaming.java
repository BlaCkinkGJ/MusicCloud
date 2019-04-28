package com.team04.musiccloud.stream;

import com.team04.musiccloud.audio.Audio;

/**
 * audio 파일의 디렉토리를 유지 관리합니다.
 *
 * `getAudioFromBack`은 Backend에서만 사용하는 코드입니다.
 * 이를 사용하면 Backend에서 조회된 audio를 객체의 멤버로 받을 수 있게 됩니다.
 *
 * `sendAudioToFront`는 Frontend에서만 사용하는 코드입니다.
 * 이를 사용하면 Backend로부터 받은 audio의 DIR을 Front는 받을 수 있습니다.
 *
 * >> 2019년 4월 29일 수정
 * extension이 붙을 수 있도록 제작하였습니다.
 *
 * @author 오기준
 * @version 2019년 4월 29일
 */
public class Streaming implements IBackStreaming, IFrontStreaming {

  private Audio audio;

  @Override
  public void getAudioFromBack(Audio audio) {
    this.audio = audio;
  }

  @Override
  public String sendAudioToFront() {
    // @TODO: 네트워크의 상태를 확인하고 가중치를 받는 함수가 필요함(ret: Integer)
    // @TODO: 가중치를 바탕으로 트랜스코드를 진행하는 함수가 필요함(ret: Audio 객체)
    return "media/audios/" + audio.getFileMeta().getUser() + '/' + audio.getFileMeta().getName() + '.'+audio.getFileMeta().getExtension();
  }
}
