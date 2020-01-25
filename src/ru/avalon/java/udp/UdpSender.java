package ru.avalon.java.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

/**
 * Упражнение, направленное на выработку умений, связанных
 * с отправкой сообщений средствами протокола UDP.
 *
 * @author Daniel Alpatov
 */
public final class UdpSender {

    public static void main(String[] args) throws IOException {
        
        String message ="";
        while(true){
        // 1. Формируем сообщение
        message = prepareMessage();
        // 2. Формируем адрес конечной точки.
        final SocketAddress address = prepareAddress();
        // 3. Формируем датаграмму.
        final DatagramPacket packet = pack(message);
        // 4. Устанавливаем адрес для пакета.
              packet.setSocketAddress(address);
        // 5. Создаём сокет
        final DatagramSocket socket = createSocket();
        // 6. Отправляем сообщение
        
            socket.send(packet);
            // 7. Освобождаем ресурсы
            if (message == "`") {
                socket.close();
                return;
            }
        }                    
    }
    
    /**
     * Возвращает сообщение.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() {
        Scanner scan = new Scanner(System.in);
        String massage = scan.nextLine();
        return massage;        
    }

    /**
     * Возвращает адрес конечной точки взаимодействия.
     *
     * @return адрес конечной точки.
     */
    private static SocketAddress prepareAddress() throws UnknownHostException {
        /*
         * TODO Реализовать метод prepareAddress класса UdpSender
         */        
        SocketAddress ia = new InetSocketAddress(InetAddress.getLocalHost(), 18181);        
        return ia;
    }

    /**
     * Возвращает сокет, описывающий взаимодействие по протоколу UDP.
     *
     * @return сокет.
     * @throws IOException
     */
    private static DatagramSocket createSocket() throws IOException {
        /*
         * TODO Реализовать метод createSocket класса UdpSender
         */
        return new DatagramSocket();
    }

    /**
     * Упаковывает текстовое сообщение в объект типа {@link DatagramPacket}.
     *
     * @param message строковое сообщение.
     *
     * @return экземпляр типа {@link DatagramPacket}.
     */
    private static DatagramPacket pack(String message) throws UnsupportedEncodingException {
        /*
         * TODO Реализовать метод pack класса UdpSender
         */
        return new DatagramPacket(message.getBytes("UTF-8"), message.length());
    }

}
