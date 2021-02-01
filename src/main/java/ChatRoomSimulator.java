import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 模拟群聊的类，每隔2s随机群聊中的随机用户发送一条消息
 */
public class ChatRoomSimulator extends Thread {

    private final List<ChatClient> mChatters;

    public ChatRoomSimulator() {
        mChatters = new ArrayList<ChatClient>() {
            {
                add(new ChatClient("A"));
                add(new ChatClient("B"));
            }
        };
    }

    /**
     * 加入群聊
     * @param client 新用户
     */
    public void addToChat(ChatClient client) {
        mChatters.add(client);
    }

    @Override
    public void run() {
        if (mChatters != null && mChatters.size() > 0) {
            Timer timer = new Timer();
            timer.schedule(new SendTask(), 2000, 2000);
        }
    }

    class SendTask extends TimerTask {
        @Override
        public void run() {
            int randomSender = new Random().nextInt(mChatters.size());
            ChatClient client = mChatters.get(randomSender);
            Message msg = new Message(client.getName(),
                    "Hello, This is " + client.getName());
            ChatRoomServer.getInstance().postMessage(msg);
        }
    }
}
