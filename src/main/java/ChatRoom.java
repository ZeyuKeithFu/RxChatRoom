public class ChatRoom {

    public static void main(String[] args) {
        System.out.println("ChatRoom started...");
        ChatRoomSimulator simulator = new ChatRoomSimulator();
        // 第一步：加入群聊
        ChatClient me = new ChatClient("C");
        simulator.addToChat(me);
        // 第二步：进入消息屏
        me.setScreen();
        // 第三步：群聊开始
        simulator.start();
    }
}