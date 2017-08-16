package com.example.lbw.guaniu.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;
import android.util.Log;

public class Utils {
	public static ArrayList<Integer> Thread_List = new ArrayList<Integer>();
	public static final String End_string = "Finishing run";
	private static final float TARGET_HEAP_UTILIZATION = 0.75f;
	public static final int ACTIVITY_ITEM = 1010;

	/**
	 * 判断邮箱是否合法
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (null == email || "".equals(email))
			return false;
		// Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
		Pattern p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isMobileNO(String mobiles){  
		String regExp = "^[1]([3][0-9]{1}|5[0-9]{1}|6[0-9]{1}|7[0-9]{1}|8[0-9]{1})[0-9]{8}$"; //"^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$"
		Pattern p = Pattern.compile(regExp);  

		Matcher m = p.matcher(mobiles);  
		return m.matches();
	}

	public static boolean isNumeric(String str) {
		if (str.matches("\\d*")) {
			return true;
		} else {
			return false;
		}
	}

	public static final boolean isEmpty(String str) {
		return (null == str) || ("".equals(str));
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dp2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static String getMyPhoneNumber(Context context) {
		TelephonyManager mTelephonyMgr;
		mTelephonyMgr = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return mTelephonyMgr.getLine1Number();
	}

	public static String getMy10DigitPhoneNumber(Context context) {
		String s = getMyPhoneNumber(context);
		return s.substring(2);
	}

	public static String ReplaceString(String source, String target,
			String repacement) {
		if (source.length() < repacement.length()) {
			return source;
		}

		int pos = source.indexOf(repacement);
		if (-1 == pos) {
			return source;
		}
		String left_str = "";
		if (pos > 1) {
			left_str = source.substring(0, pos - 1);
		}
		String right_str = source.substring(pos + repacement.length());
		String target_str = "";
		target_str = left_str;
		target_str += target;
		target_str += right_str;

		return target_str;
	}

	static final int BOOK_CHANNEL_WIDTH = 70;// DIP
	static final int BOOK_CHANNEL_SPACING = 3;

	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static void C() {
	}

	public static long getThreadId() {
		Thread t = Thread.currentThread();
		return t.getId();
	}

	public static String getThreadSignature() {
		Thread t = Thread.currentThread();
		long l = t.getId();
		String name = t.getName();
		long p = t.getPriority();
		String gname = t.getThreadGroup().getName();
		return (name + ":(id)" + l + ":(priority)" + p + ":(group)" + gname);
	}

	public static void logThreadSignature() {
		Log.d("ThreadUtils", getThreadSignature());
	}

	public static String GetTimeString() {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd, HH:mm:ss ");
		Date curDate = new Date(System.currentTimeMillis());//
		String str = formatter.format(curDate);
		return str;
	}
	

	public static synchronized void sleepForInSecs(Thread thread, int secs) {
		try {
			if (thread != null) {
				thread.wait(secs * 1000);
			} else {
				Thread.sleep(secs * 1000);
			}

			Log.v("sleepForInSecs", "TIME:" + GetTimeString());
		} catch (Exception x) {
			Log.v("sleepForInSecs", "exception:" + x.getMessage());
		}
	}

	// The following two methods are used by worker threads
	// that we will introduce later.
	public static Bundle getStringAsABundle(String message) {
		Bundle b = new Bundle();
		b.putString("message", message);
		return b;
	}

    //把日期转为字符串  
    public static String ConverToString(Date date)  
    {  
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
          
        return df.format(date);  
    }  
    //把字符串转为日期  
    public static Date ConverToDate(String strDate) 
    {  
    	try{
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	        return df.parse(strDate);
    	}catch(Exception ex){
    		return null;
    	}
    }  
    
    public static Date getTime(String time)
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    	Date d;
    	try
    	{
    		d = sdf.parse(time);
    		return d;
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	return null;    	
    }
     
	/**
	 * 将时间戳转为代表"距现在多久之前"的字符串
	 * @param timeStr	时间戳
	 * @return
	 */
	public static String getStandardDate(Date date) {

		StringBuffer sb = new StringBuffer();

		long t = date.getTime();
		long time = System.currentTimeMillis() - t;
		long mill = (long) Math.ceil(time /1000);//秒前

		long minute = (long) Math.ceil(time/60/1000.0f);// 分钟前

		long hour = (long) Math.ceil(time/60/60/1000.0f);// 小时

		long day = (long) Math.ceil(time/24/60/60/1000.0f);// 天前

		if (day - 1 > 0) {
			sb.append(day + "天");
		} else if (hour - 1 > 0) {
			if (hour >= 24) {
				sb.append("1天");
			} else {
				sb.append(hour + "小时");
			}
		} else if (minute - 1 > 0) {
			if (minute == 60) {
				sb.append("1小时");
			} else {
				sb.append(minute + "分钟");
			}
		} else if (mill - 1 > 0) {
			if (mill == 60) {
				sb.append("1分钟");
			} else {
				sb.append(mill + "秒");
			}
		} else {
			sb.append("刚刚");
		}
		if (!sb.toString().equals("刚刚")) {
			sb.append("前");
		}
		return sb.toString();
	}
    
	public static String getStringFromABundle(Bundle b) {
		return b.getString("message");
	}

	public static final int MB = 1024 * 1024;

	/**
	 * ����sdcard�ϵ�ʣ��ռ�
	 * 
	 * @return
	 */
	public static int GetFreeSpaceOnSd() {
		try {
			StatFs stat = new StatFs(Environment.getExternalStorageDirectory()
					.getPath());
			double sdFreeMB = ((double) stat.getAvailableBlocks() * (double) stat
					.getBlockSize()) / MB;
			return (int) sdFreeMB;
		} catch (Exception ex) {
			Log.v("uTILS", "MESSAGE:" + ex.getMessage());
			return 0;
		}
	}

}
