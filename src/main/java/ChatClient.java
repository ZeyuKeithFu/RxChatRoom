import io.reactivex.rxjava3.subjects.PublishSubject;

/**
 * 群聊成员的类
 */
public class ChatClient {
    private String mName;
    private PublishSubject<Message> mMessageObservable;

    public ChatClient(String name) {
        mName = name;
        mMessageObservable = ChatRoomServer.getInstance().observeMessageSubject();
    }

    public String getName() {
        return mName;
    }

    /**
     * 设置消息屏
     */
    public void setScreen() {
        System.out.println("=================");
        System.out.println(mName + "'s Screen Output");
        System.out.println("=================");
        mMessageObservable.subscribe(message -> {
            StringBuilder outputBuilder = new StringBuilder();
            String user = message.getUser();
            if (user.equals(mName)) {
                outputBuilder.append("I said \"");
            } else {
                outputBuilder.append(user).append(" said \"");
            }
            outputBuilder.append(message.getContent()).append("\"");
            System.out.println(outputBuilder.toString());
        });
    }
}
