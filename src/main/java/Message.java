/**
 * 消息类型的数据类
 */
public class Message {

    private String mUser;
    private String mContent;

    public Message(String user, String content) {
        mUser = user;
        mContent = content;
    }

    public String getUser() {
        return mUser;
    }

    public String getContent() {
        return mContent;
    }
}
