public class MyAdapter extends BaseAdapter {  

        private LayoutInflater mInflater; 
		private int[] ListItemIcon = {R.drawable.icon1 , R.drawable.icon1 ,R.drawable.icon1 , R.drawable.icon1,R.drawable.icon1};
		private String[] ListItemText = {"IC checker" , "Color temp" , "LCD checker" ,"Auto test","On/Off test" };
				
        public MyAdapter(Context context) {  
            this.mInflater = LayoutInflater.from(context);  
        }  
		
        @Override  
        public int getCount() {  
            return ListItemIcon.length();  
        }  
  
        @Override  
        public Object getItem(int arg0) {  
            return ListItemText[arg0];  
        }  
  
        @Override  
        public long getItemId(int arg0) {  
            return 0;  
        }  
  
        @Override  
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            Holder mHolder;
			if (v == null){
				v = mInflater.inflate(R.layout.mainListItem, null);
				mHolder = new Holder();
				v.setTag(mHolder);
				mHolder.ListImageView = (ImageView)v.findViewById(R.id.ListViewItem_image);
			    mHolder.ListTextView =  (Textview)v.findViewById(R.id.ListViewItem_text);
			}else{
			mHolder = (Holder)v.getTag();	
			}
            mHolder.ListImageView.setImageRes(ListItemIcon[position]);
			mHolder.ListTextView.setText(ListItemText[position]);
            mHolder.ListImageView.setOnClickListener(new OnClickListener(){
            @Override 
            public void onClick(View view) { 
			SwitchClass(position);
            }});
            return v;  
        }  
		
		private SwitchClass(int position){
		String pickedItem = ListItemText[position];
                switch (pickedItem){
                    case "IC checker":
                        mIntent.setClass(mainMenuActivity.this , icCheckerActiviy.class);
                        startActivity(mIntent);
                        break;
                    case "LCD checker":

                        break;
                    case "Color temp":
                        mIntent.setClass(mainMenuActivity.this , ColorTempActivity.class);
                        startActivity(mIntent);
                        break;
                    case "Auto test":

                        break;
                    case "On/Off test":

                        break;
                }	
		}
		
		Class Holder{
        public ImageView ListImageView;
        public TextView ListTextView;	
        public Holder();				
		}
		
    }  
	
mainListItem.xml	
<?xml version="1.0" encoding="utf-8"?>   
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
    android:layout_width="match_parent"  
    android:layout_height="match_parent"  
    android:background="#fff"  
    android:orientation="vertical" >
	
    <ImageView  
            android:id="@+id/ListViewItem_image"  
            android:layout_width="wrap_content"  
            android:layout_height="wrap_content"  
            android:layout_marginRight="10dp"/>
			
    <TextView  
            android:id="@+id/ListViewItem_Text"  
            android:layout_width="wrap_content"  
            android:layout_height="wrap_content"  
            android:layout_marginRight="10dp"/>
			
  
</LinearLayout>  
	
	
	
	
	
	
	