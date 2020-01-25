package ru.avalon.java.tcp;

import java.io.*;
import java.net.*;

/**
 * Упражнение на выаботку умений связанных с получением сообщений,
 * отправленных с использованием протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpReceiver {

    public static void main(String[] args) throws IOException {
        // 1. Определяем порт, на котором ожидается соединение.
        final int port = 8080;
        // 2. Подготавливаем серверный сокет.
        final ServerSocket listener = prepareServerSocket(port);
        // 3. Принимаем соединение.
        Socket socket = listener.accept();
        // 4. Полоучаем сообщение.
        final String message = receive(socket);
        System.out.println(message);
        // 5. Закрываем соединение.
        socket.close();
        // 6. Закрываем серверный сокет.
        listener.close();
    }

    /**
     * Возвращает серверный сокет, связанный с портом, описанным
     * параметром {@code port}.
     *
     * @param port порт, на котором предполагается получать входящие
     *             соединения.
     *
     * @return серверный сокет, связанный с портом {@code port}.
     */
    private static ServerSocket prepareServerSocket(int port) throws IOException {
        /*
         * TODO Реализовать метод prepareServerSocket класса TcpReceiver
         */
        return new ServerSocket(port);
    }

    /**
     * Возвращает сообщение, прочитанное из входящего потока,
     * указанного сокета.
     *
     * @param socket сокет, описывающий сетевое соединение.
     *
     * @return строковое сообщение.
     */
    private static String receive(Socket socket) throws IOException {
        /*
         * TODO Реализовать метод receive класса TcpReceiver
         */
        try(InputStream is = socket.getInputStream()){
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);
            return br.readLine();
        }
    }

}
