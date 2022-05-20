
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class Node{
        int d;
        Node next=null;
        
        public Node(int data){
          d = data;
        }
    }

class LList{
    Node first=null;
    public void addFirst(int data){
        Node node = new Node(data);
        if(first==null)
            first=node;
        else{
            node.next=first;
            first=node;
        }
    }
    
    public void removeFirst(){
            first=first.next;
        }
    
    public void delete(int value){
        Node temp=first;
        Node temp1=first;
        
        if(first.d==value){
            first=temp.next;
            temp=null;
        }
        else{
            while(temp.next!=null){
                if(temp.next.d==value){
                    break;
                }
                temp = temp.next;
                if(temp.next.next==null){
                   temp1=temp; 
                }
            }
            if(temp.next == null&&temp.d == value){
                temp1.next=null;
                temp=temp1;
            }
            else{
                Node current=temp;
                Node center=temp.next;
                current.next=center.next;
                center.next=null;
            }
        }
    }

    
    public String Display(){
        Node current=first;
        String output = "Head --- ";
        while(current!=null)
        {
            output += current.d;
            if(current.next != null)
                output += " --- ";
            current=current.next;
        }
        
        return output;
    }
}

public class LLMPlayerGUI extends javax.swing.JFrame {
    
    LList list=new LList();
    long totalLength;
    long pause;
    FileInputStream fis;
    BufferedInputStream bis;
    Player player;
    
    File file=null;
    
    public LLMPlayerGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        playbtn = new javax.swing.JButton();
        pausebtn = new javax.swing.JButton();
        resumebtn = new javax.swing.JButton();
        prevbtn = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        stopbtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playbtn.setText("Play");
        playbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playbtnMouseReleased(evt);
            }
        });

        pausebtn.setText("Pause");
        pausebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pausebtnMouseReleased(evt);
            }
        });

        resumebtn.setText("Resume");
        resumebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resumebtnMouseReleased(evt);
            }
        });

        prevbtn.setText("Prev");
        prevbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                prevbtnMouseReleased(evt);
            }
        });
        prevbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevbtnActionPerformed(evt);
            }
        });

        nextbtn.setText("Next");
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        stopbtn.setText("Stop");
        stopbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopbtnMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Music Player");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pausebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resumebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prevbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playbtn)
                    .addComponent(pausebtn)
                    .addComponent(resumebtn)
                    .addComponent(prevbtn)
                    .addComponent(nextbtn)
                    .addComponent(stopbtn))
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }//GEN-END:initComponents

    private void prevbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevbtnActionPerformed
    
    }//GEN-LAST:event_prevbtnActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
       
    }//GEN-LAST:event_nextbtnActionPerformed

    private void playbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playbtnMouseReleased
        JFileChooser chooser = new JFileChooser();
       int response = chooser.showOpenDialog(null);
       if(response==JFileChooser.APPROVE_OPTION){
           file=chooser.getSelectedFile();
           String song=file+"";
           String name=chooser.getSelectedFile().getName();
           lbl.setText(name);
           try{
               fis=new FileInputStream(file);
               bis=new BufferedInputStream(fis);
               player=new Player(bis);
               totalLength=fis.available();
               
               new Thread(){
                   public void run(){
                       try{
                           player.play();
                       } catch(JavaLayerException ex){
                           Logger.getLogger(LLMPlayerGUI.class.getName()).log(Level.SEVERE,null,ex);
                       }
                   }
               }.start();
           }catch(JavaLayerException ex)
               {
                  Logger.getLogger(LLMPlayerGUI.class.getName()).log(Level.SEVERE,null,ex);
       }catch(IOException ex){
         Logger.getLogger(LLMPlayerGUI.class.getName()).log(Level.SEVERE,null,ex);
       }
       }
    }//GEN-LAST:event_playbtnMouseReleased

    private void pausebtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pausebtnMouseReleased
        if(player!=null){
            try{
                pause=fis.available();
                player.close();
            }catch(IOException ex){
                Logger.getLogger(LLMPlayerGUI.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }//GEN-LAST:event_pausebtnMouseReleased

    private void resumebtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resumebtnMouseReleased
      try{
           fis=new FileInputStream(file);
           bis=new BufferedInputStream(fis);
           player=new Player(bis);
           fis.skip(totalLength-pause);
           new Thread(){
               public void run(){
                   try{
                       player.play();
                   }
                   catch(JavaLayerException ex){
                       Logger.getLogger(LLMPlayerGUI.class.getName()).log(Level.SEVERE,null,ex);
                   }
               }
           }.start();
       }catch(IOException ex){
           Logger.getLogger(LLMPlayerGUI.class.getName()).log(Level.SEVERE,null,ex);
       }
         catch(JavaLayerException ex){
            Logger.getLogger(LLMPlayerGUI.class.getName()).log(Level.SEVERE,null,ex);
         }                             
    }//GEN-LAST:event_resumebtnMouseReleased

    private void stopbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopbtnMouseReleased
        if(player!=null){
            player.close();
            lbl.setText(null);
        }
    }//GEN-LAST:event_stopbtnMouseReleased

    private void prevbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevbtnMouseReleased
        if(player!=null){
         
        }
       
    }//GEN-LAST:event_prevbtnMouseReleased

  
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LLMPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LLMPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LLMPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LLMPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LLMPlayerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton pausebtn;
    private javax.swing.JButton playbtn;
    private javax.swing.JButton prevbtn;
    private javax.swing.JButton resumebtn;
    private javax.swing.JButton stopbtn;
    // End of variables declaration//GEN-END:variables
}
