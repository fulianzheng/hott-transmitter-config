package gde.mdl.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

/**
 * Class to manage SWT resources (Font, Color, Image and Cursor)
 * There are no restrictions on the use of this code.
 */
public class SWTResourceManager {

	private static HashMap<String, Object>	resources				= new HashMap<String, Object>();
	private static Vector<Widget>						users						= new Vector<Widget>();
	private static SWTResourceManager				instance				= new SWTResourceManager();

	private static DisposeListener					disposeListener	= new DisposeListener() {
		@Override
		public void widgetDisposed(DisposeEvent e) {
			SWTResourceManager.users.remove(e.getSource());
			if (SWTResourceManager.users.size() == 0) dispose();
		}
	};

	/**
	 * This method should be called by *all* Widgets which use resources
	 * provided by this SWTResourceManager. When widgets are disposed,
	 * they are removed from the "users" Vector, and when no more
	 * registered Widgets are left, all resources are disposed.
	 * <P>
	 * If this method is not called for all Widgets then it should not be called
	 * at all, and the "dispose" method should be explicitly called after all
	 * resources are no longer being used.
	 */
	public static void registerResourceUser(Widget widget) {
		if (SWTResourceManager.users.contains(widget)) return;
		SWTResourceManager.users.add(widget);
		widget.addDisposeListener(SWTResourceManager.disposeListener);
	}

	public static void dispose() {
		Iterator<String> it = SWTResourceManager.resources.keySet().iterator();
		while (it.hasNext()) {
			Object resource = SWTResourceManager.resources.get(it.next());
			if (resource instanceof Font)
				((Font) resource).dispose();
			else if (resource instanceof Color)
				((Color) resource).dispose();
			else if (resource instanceof Image)
				((Image) resource).dispose();
			else if (resource instanceof Cursor) ((Cursor) resource).dispose();
		}
		SWTResourceManager.resources.clear();
	}

	public static Font getFont(String name, int size, int style) {
		return getFont(name, size, style, false, false);
	}

	@SuppressWarnings("rawtypes")
	public static Font getFont(String name, int size, int style, boolean strikeout, boolean underline) {
		String fontName = name + "|" + size + "|" + style + "|" + strikeout + "|" + underline;
		if (SWTResourceManager.resources.containsKey(fontName)) return (Font) SWTResourceManager.resources.get(fontName);
		FontData fd = new FontData(name, size, style);
		if (strikeout || underline) {
			try {
				Class lfCls = Class.forName("org.eclipse.swt.internal.win32.LOGFONT");
				Object lf = FontData.class.getField("data").get(fd);
				if (lf != null && lfCls != null) {
					if (strikeout) lfCls.getField("lfStrikeOut").set(lf, new Byte((byte) 1));
					if (underline) lfCls.getField("lfUnderline").set(lf, new Byte((byte) 1));
				}
			}
			catch (Throwable e) {
				System.err.println("Unable to set underline or strikeout" + " (probably on a non-Windows platform). " + e);
			}
		}
		Font font = new Font(Display.getDefault(), fd);
		SWTResourceManager.resources.put(fontName, font);
		return font;
	}

	public static Image getImage(String url, Control widget) {
		Image img = getImage(url);
		if (img != null && widget != null) img.setBackground(widget.getBackground());
		return img;
	}

	public static Image getImage(String url) {
		try {
			url = url.replace('\\', '/');
			if (url.startsWith("/")) url = url.substring(1);
			if (SWTResourceManager.resources.containsKey(url)) return (Image) SWTResourceManager.resources.get(url);
			Image img = new Image(Display.getDefault(), SWTResourceManager.instance.getClass().getClassLoader().getResourceAsStream(url));
			SWTResourceManager.resources.put(url, img);
			return img;
		}
		catch (Exception e) {
			System.err.println("SWTResourceManager.getImage: Error getting image " + url + ", " + e);
			return null;
		}
	}

	public static Color getColor(int red, int green, int blue) {
		String name = "COLOR:" + red + "," + green + "," + blue;
		if (SWTResourceManager.resources.containsKey(name)) return (Color) SWTResourceManager.resources.get(name);
		Color color = new Color(Display.getDefault(), red, green, blue);
		SWTResourceManager.resources.put(name, color);
		return color;
	}

	public static Cursor getCursor(int type) {
		String name = "CURSOR:" + type;
		if (SWTResourceManager.resources.containsKey(name)) return (Cursor) SWTResourceManager.resources.get(name);
		Cursor cursor = new Cursor(Display.getDefault(), type);
		SWTResourceManager.resources.put(name, cursor);
		return cursor;
	}

}
