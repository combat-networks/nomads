package us.ihmc.rms;

import java.io.File;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * * Similar class to the update files but it only allows to get the
 *   local path that users want to update in the remote machines.
 *
 * @author  Maggie Breedy
 * @version $Revision$
 * $Date$
 * 
 */
public class UpdateDirectoryDialog extends JDialog 
{
    public UpdateDirectoryDialog() 
    {
        initComponents();
        _jRadioButton2.setSelected (true);
        _update = false;
    }
    
    protected void initComponents()
    {
        setModal (true);
		setTitle ("Synchronize Directories");
        setSize (500, 220);
		getContentPane().setLayout (new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		setVisible (false);
        
        // Add upper Panel
        JPanel upPanel = new JPanel (new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 0.4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        getContentPane().add (upPanel, gbc);
        
        JPanel radioPanel = new JPanel (new GridBagLayout());
        radioPanel.setBorder (new EtchedBorder());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.insets = new Insets (5,13,5,13);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        getContentPane().add (radioPanel, gbc);
                
        // Add buttons Panel
        JPanel btnPanel = new JPanel (new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.2;
        gbc.weighty = 0.2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.SOUTH;
        getContentPane().add (btnPanel, gbc);
        
        //Up panel components
        gbc = new GridBagConstraints();
        JLabel jLabel1 = new JLabel ("Local Directory");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets (5,13,5,13);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        upPanel.add (jLabel1, gbc);
        
        _jtfLocalFile = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.ipady = 3;
        /*Dimension dimTf = _jtfLocalFile.getMinimumSize();
        int htf = (int) dimTf.getHeight();
        _jtfLocalFile.setMaximumSize (new Dimension (220, htf));
        _jtfLocalFile.setPreferredSize (new Dimension (220, htf));*/
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets (5,13,13,5);
        upPanel.add (_jtfLocalFile, gbc);
        
        gbc = new GridBagConstraints();
        JButton jbBrowse = new JButton ("Browse...");
        jbBrowse.setBorder (BorderFactory.createBevelBorder (BevelBorder.RAISED));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets (5,5,5,13);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipady = 2;
        gbc.gridheight = 2;
        gbc.weightx = 0.5;
        upPanel.add (jbBrowse, gbc);
        
        gbc = new GridBagConstraints();
        JLabel jLabel2 = new JLabel ("Remote Directory Path ");
        jLabel2.setHorizontalAlignment (SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets (5,13,13,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        upPanel.add (jLabel2, gbc);
        
        _jtfRemoteDir = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        gbc.ipady = 3;
        /*Dimension dimTf2 = _jtfRemoteDir.getMinimumSize();
        int htf2 = (int) dimTf2.getHeight();
        _jtfRemoteDir.setMaximumSize (new Dimension (100, htf2));
        _jtfRemoteDir.setPreferredSize (new Dimension (100, htf2));*/
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets (5,5,5,13);
        upPanel.add (_jtfRemoteDir, gbc);
        
        gbc = new GridBagConstraints();
        ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        JRadioButton jRadioButton1 = new JRadioButton();
        _jRadioButton2 = new JRadioButton();
        jRadioButton1.setText ("Strict Update");
        buttonGroup1.add(jRadioButton1);
        gbc.gridx = 0;
        gbc.gridy = 0;
        radioPanel.add (jRadioButton1, gbc);
        gbc.insets = new Insets (5,13,5,33);
        
        _jRadioButton2.setText("Loose Update");
        buttonGroup1.add(_jRadioButton2);
        gbc.gridx = 1;
        gbc.gridy = 0;
        radioPanel.add (_jRadioButton2, gbc);
        gbc.insets = new Insets (5,33,5,13);
        
        gbc = new GridBagConstraints();
        //Buttons Panel components
        gbc = new GridBagConstraints();
        JButton jbUpdate = new JButton ("Update");
        jbUpdate.setBorder (BorderFactory.createBevelBorder (BevelBorder.RAISED));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets (5,13,13,13);
        gbc.gridx = 0;
        gbc.gridy = 0;
        //gbc.ipady = 5;
        gbc.weightx = 0.5;
        btnPanel.add (jbUpdate, gbc);
        
        JButton jbCancel = new JButton ("Cancel");
        jbCancel.setBorder (BorderFactory.createBevelBorder (BevelBorder.RAISED));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets (5,13,13,13);
        gbc.gridx = 1;
        gbc.gridy = 0;
        //gbc.ipady = 5;
        gbc.weightx = 0.5;
        btnPanel.add (jbCancel, gbc);
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds ((screenSize.width-420)/2, (screenSize.height-224)/2, 420, 224);
        
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _strictUpdate = true;
            }
        });
        
        _jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _strictUpdate = false;
            }
        });
        
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _localFilePath = _jtfLocalFile.getText();
                _remoteFilePath = _jtfRemoteDir.getText();
                if (_localFilePath.length() == 0) {             
                    JOptionPane.showMessageDialog (new JFrame(), "Must select local file", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    _update = true;
                    dispose();
                }
            }
        });
        
        jbCancel.setText("Cancel");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _localFilePath = null;
                //_remoteFilePath = null;
                _update = false;
                _strictUpdate = false;
                dispose();
            }
        });
        
        jbBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String path = null;
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode (JFileChooser.DIRECTORIES_ONLY);
                int result = chooser.showDialog (new JFrame(), "Choose Directory");
                if (result == JFileChooser.APPROVE_OPTION) {
                    System.out.println ("..Opening... ");
                    path = chooser.getSelectedFile().getAbsolutePath();
                    System.out.println ("****Path: " + path);
                    if (path.length() == 0) {
                        JOptionPane.showMessageDialog (new JFrame(), path + " is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else {
                        System.out.println ("****Opening: " + path);
                        _jtfLocalFile.setText (path);
                    }
                    System.out.println ("Opening " + path + "....");
                }
            }
        });
    }
    
    public boolean update()
    {
        return _update;
    }
    
    public boolean updateStrict()
    {
        return _strictUpdate;
    }

    public String getLocalFilePath()
    {
        System.out.println ("_localFilePath: " + _localFilePath);
        return _localFilePath;
    }
    
    public String getRemotePath()
    {
        System.out.println ("_remoteFilePath: " + _remoteFilePath);
        return _remoteFilePath;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        UpdateDirectoryDialog ud = new UpdateDirectoryDialog();
        ud.setVisible (true);
    }
    
    /**
     * The RMS file filter
     */
    public class RMSFileFilter extends FileFilter
    {
        public RMSFileFilter() 
        {
        }
        
        public boolean accept(File f) 
        {
            return f.isDirectory();
        }
        
        public String getDescription() 
        {
            return "";
        }
    }
    
    //Variables    
    private boolean _strictUpdate = false;
    private boolean _update;
    private String _localFilePath;
    private String _remoteFilePath;
    protected JRadioButton _jRadioButton2;
    protected JTextField _jtfLocalFile;
    protected JTextField _jtfRemoteDir;
}