package gui;

import java.awt.Dimension;
import musicplayer.MusicPlayer;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame {
	JPanel panel;
	JButton play, stop, pause, open;
	JTextField text;
	JMenuBar menubar;
	JFileChooser file;
	MusicPlayer music;
	File f;
	
	public MainFrame(String title) {
		super(title);
		this.setSize(320, 120);
		this.setLayout(new FlowLayout());
		addButtons();
		addFileChooser();
		setPanel();
		music = new MusicPlayer();
		text = new JTextField();
		text.setColumns(24);
		text.setText("No file Selected");
		text.setEditable(false);
		this.add(text);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
		panel = new JPanel();
		panel.add(play);
		panel.add(stop);
		panel.add(pause);
		panel.add(open);
		this.add(panel);
		panel.setVisible(true);
	}
	
	private void addButtons() {
		play = new JButton("Play");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==play) {
					music.playSong(f);
				}
			}
		});
		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==stop) {
					music.stopSong();
				}
			}
		});
		pause = new JButton("Pause");
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==pause) {
					music.pauseSong();
				}
			}
		});
		open = new JButton("Open");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==open) {
					int returnVal = file.showOpenDialog(getParent());
					if (returnVal==file.APPROVE_OPTION) {
						f = file.getSelectedFile();
						text.setText(f.toString());
					}
				}
			}
		});
	}
	
	private void addFileChooser() {
		file = new JFileChooser();
		String [] formats = new String [] {"mp3"};
		FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 File (*.mp3)", formats);
		file.setFileFilter(filter);
	}
	
	public static void main(String [] args) {
		MainFrame frame = new MainFrame("JMusicPlayer");
	}

}
