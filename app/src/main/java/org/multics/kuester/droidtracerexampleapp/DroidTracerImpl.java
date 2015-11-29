/*************************************************************************************
 *  This is part of DroidTracer (http://kuester.multics.org/DroidTracer/#droidtracer).
 *  
 *  Copyright (c) 2013 by Jan-Christoph Küster <jckuester@gmail.com>
 *   
 *  DroidTracer is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  DroidTracer is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with DroidTracer.  If not, see <http://www.gnu.org/licenses/>.
 ************************************************************************************/

package org.multics.kuester.droidtracerexampleapp;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.util.SparseArray;

import org.multics.kuester.droidtracer.DroidTracerService;
import org.multics.kuester.droidtracer.OnEventCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DroidTracerImpl extends DroidTracerService implements OnEventCallback {

	private final IBinder mBinder = new LocalBinder();
	
	@Override
	public void onCreate() {
        super.onCreate();

        // register callback methods for events
        registerOnEventListener(this);

        // TODO this wait is hacky (waiting for netlink init in async task)
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // receive events for some app (put UID of your choice)
        startInterceptingApp(10051);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
	}


	@Override
    public void onEvent(int time, int uid, String service, String method,
                 List<Object> params, String[] paramTypes, long readErrorCount) {

        // USE EVENT FOR YOUR ANALYSIS HERE

        if(params != null) {
            Log.i("DroidTracerExampleApp", service + ", " + method + "," + params);
        }
	}
}