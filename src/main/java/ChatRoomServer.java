import io.reactivex.rxjava3.subjects.PublishSubject;

/**
 * 模拟群聊server的单例类
 * 对外只暴露一个发送消息和观察消息的接口
 */
public class ChatRoomServer {

    private PublishSubject<Message> mMessageSubject = PublishSubject.create();
    private static ChatRoomServer INSTANCE;

    private ChatRoomServer() { }

    public static ChatRoomServer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ChatRoomServer();
        }
        return INSTANCE;
    }

    /**
     * 观察所有消息
     */
    public PublishSubject<Message> observeMessageSubject() {
        return mMessageSubject;
    }

    /**
     * 发送新消息
     */
    public void postMessage(Message msg) {
        mMessageSubject.onNext(msg);
    }
}
