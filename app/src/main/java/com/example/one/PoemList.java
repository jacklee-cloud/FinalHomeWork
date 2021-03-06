package com.example.one;

import java.util.List;

public class PoemList {

    /**
     * code : 200
     * msg : success
     * newslist : [{"title":"宿府","content":"清秋幕府井梧寒，独宿江城蜡炬残。永夜角声悲自语，中庭月色好谁看。风尘荏苒音书绝，关塞萧条行路难。已忍伶俜十年事，强移栖息一枝安。","intro":"【注解】：１、永夜句：意谓长夜中唯闻号角声像在自作悲语。永夜：长夜。２、风尘荏苒：喻战乱不绝。荏苒：犹辗转。３、已忍句：指自天宝十四载（七五五）安禄山反至写此诗，已忍受了十年的伶俜生活。伶俜：飘零之意。４、强移句：用《庄子·逍遥游》\u201c鹪鹩巢于深林，不过一枝\u201d意，喻自己之入严幕，原是勉强以求暂时的安居。【韵译】：深秋时节，幕府井边梧桐疏寒；独宿江城，更深人静残烛暗淡。长夜里，号角声有如人的悲语；中天月色虽好，谁有心情仰看？乱中四处漂泊，亲朋音书皆断，关塞零落萧条，行路十分艰难。忍受困苦，我颠沛流离了十年；勉强栖息一枝，暂借幕府偷安。【评析】：这首诗是依人作客，抒写旅愁，有一种百无聊赖之情。前四句写景，后四名抒情。首联写独宿江城，环境清寒；颔联写\u201c独宿\u201d的所闻所见；颈联写战乱未息，处世艰难；末联写漂泊十年，如今暂且栖安。全诗表达了作者悲凉深沉的情感，流露了怀才不遇的心绪。 ","kind":"七言律诗","author":"杜甫"}]
     */

    private int code;
    private String msg;
    private List<PoemBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<PoemBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<PoemBean> newslist) {
        this.newslist = newslist;
    }

}
