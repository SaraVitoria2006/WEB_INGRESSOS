package com.show.web_ingressos.service;

import com.show.web_ingressos.model.Cliente;
import com.show.web_ingressos.model.Setor;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    private List<Setor> setores = new ArrayList<>();

    public ShowService() {
        setores.add(new Setor("Pista Premium", 850.00, 100));
        setores.add(new Setor("Pista Comum", 450.00, 300));
        setores.add(new Setor("Pista black", 50.00, 10));
        setores.add(new Setor("Pista vip", 980.00, 30));
    }

    public List<Setor> getSetores() { return setores; }

    public byte[] processarVenda(int indice, Cliente cliente) throws IOException {
        if (indice < 0 || indice >= setores.size()) return null;
        Setor s = setores.get(indice);
        if (!s.temDisponibilidade()) return null;

        s.venderIngresso();
        return gerarTicketPNG(s.getNome(), s.getPreco(), cliente);
    }

    private byte[] gerarTicketPNG(String setor, double preco, Cliente c) throws IOException {
        BufferedImage img = new BufferedImage(600, 300, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 600, 300);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(10, 10, 580, 280);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("INGRESSO - SHOW 2026", 50, 50);
        g2d.setFont(new Font("Arial", Font.PLAIN, 15));
        g2d.drawString("NOME: " + c.getNome(), 50, 100);
        g2d.drawString("SETOR: " + setor, 50, 130);
        g2d.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        return baos.toByteArray();
    }
}