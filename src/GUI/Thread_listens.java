package GUI;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;

import Objects.WiFiList;
import Tools.readcsv;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.ParseException;
import java.util.ArrayList;

import Main.Main;

/**
 * 
 *
 */
public class Thread_listens implements Runnable {

	@Override
	public void run() {
		try {

			Path directoryPath = FileSystems.getDefault().getPath(Main.folder.getPath());

			WatchService watchService = directoryPath.getFileSystem().newWatchService();
			directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

			//Start infinite loop to watch changes on the directory
			while (true) {

				WatchKey watchKey = watchService.take();

				// poll for file system events on the WatchKey
				for (final WatchEvent<?> event : watchKey.pollEvents()) {
					//Calling method
					takeActionOnChangeEvent(event);
				}

				//Break out of the loop if watch directory got deleted
				if (!watchKey.reset()) {
					watchKey.cancel();
					watchService.close();
			
					//Break out from the loop
					break;
				}
			}

		} catch (InterruptedException interruptedException) {
			System.out.println("Thread got interrupted:"+interruptedException);
			return;
		} catch (Exception exception) {
			exception.printStackTrace();
			return;
		}

	}

	private void takeActionOnChangeEvent(WatchEvent<?> event) {

		Kind<?> kind = event.kind();

		if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
			ArrayList<WiFiList> NewArray=new ArrayList<WiFiList>();
			Main.setWifilist(NewArray);

			try {
				File filePath= new File(Main.folder.getPath());
				readcsv.readcsvFolder(filePath);

			}
			catch (ParseException e) {

				e.printStackTrace();
			}
		} 

		else if (kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {

			ArrayList<WiFiList> NewArray=new ArrayList<WiFiList>();
			Main.setWifilist(NewArray);
			try {
				File filePath= new File(Main.folder.getPath());
				readcsv.readcsvFolder(filePath);

			} 
			catch (ParseException e) {
				e.printStackTrace();
			}
		} 

		else if (kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {

			ArrayList<WiFiList> NewArray=new ArrayList<WiFiList>();
			Main.setWifilist(NewArray);
			try {
				File filePath= new File(Main.folder.getPath());
				readcsv.readcsvFolder(filePath);

			} 
			catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}
}

