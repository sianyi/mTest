


class ImageFolder{
	
	private static int RESOURCE_ID =0;
    private static int RESOURCE_URI =1;
	
	private Context mContext; 
	private string NAME;
	private int TYPE;
	private int[] resource;
	private ArrayList<Uri> resourceUri;
	private int page = 0;
	private boolean isEmpty = true;
	private int maxPage = 0;
	private int maxImageWidth = 1440 ,maxImageHeight = 2560 ;
	
	
	public void addImage(Uri imgUri){
		resourceUri.add(Uri);
		update();
		page = resourceUri.indexOf(Uri);
	}
	
	public void removeImage(Uri imgUri){
		resourceUri.remove(Uri);
		update();
	}
	
	public boolean isEmpty(){
		return isEmpty;
	}
	
	public ImageFolder(int[] res , string foldername){
		TYPE = RESOURCE_ID
		NAME = name;
		resource = res;
		if (res != null){
			isEmpty = false;
			maxPage = resource.length-1;
		}
	}
	
	public ImageFolder(ArrayList<Uri> resUri , string foldername){
		TYPE = RESOURCE_URI;
		NAME = name;
		resourceUri = resUri;
		if (resourceUri != null || !resourceUri.isEmpty()){
			isEmpty = false;
			maxPage = resourceUri.size()-1;
		}
	}
		
	public void update(){
		if (TYEP == RESOURCE_URI){
			if (resourceUri.isEmpty()){
				isEmpty = true;
				page = 0;
			}else{
				isEmpty = false;
				maxPage = resourceUri.size()-1;
				if (page > maxPage){
					page = 0;
				}
			}
	    }
	}
	
	public void pageFordward(){
		if (!isEmpty){
		page++;
		if (page > maxPage)
			page = 0;
		}
	}
	
	
	public void pageBackWard(){
		if (!isEmpty){
		page--;
		if (page < )
			page = maxPage;
		}
	}
	
    public void pageToDefaut(){
		if (!isEmpty){
		page = 0;	
		}
	}
	
	
	public Bitmap getImage(){
		Bitmap result_bitmap = null;	
		if(!isEmpty){
			switch(TYEP){
				case RESOURCE_ID:
					result_bitmap = decodeSampledBitmap(resource[page]);
					break;
				case RESOURCE_URI:
					result_bitmap = decodeSampledBitmap(resourceUri.get(page));
					break;
			}
		}
		return result_bitmap;
	}
	
	
	public Bitmap decodeSampledBitmap(Uri uri) {
        Bitmap result_bitmap = null;
        ContentResolver cr = mContext.getContentResolver();

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(cr.openInputStream(uri), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        try {
            result_bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result_bitmap;
    }

    public int calculateInSampleSize(
            BitmapFactory.Options options) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > maxImageHeight || width > maxImageWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) maxImageHeight);
            final int widthRatio = Math.round((float) width / (float) maxImageWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        Log.d("Sianyi", "inSampleSize is " + inSampleSize);
        return inSampleSize;
    }


    public Bitmap decodeSampledBitmap(int resource_id) {
        Bitmap result_bitmap = null;
        Resources res = mContext.getResources();

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        try {

            BitmapFactory.decodeStream(res.openRawResource(resource_id), null, options);
            //BitmapFactory.decodeResource(res, resource_id, options);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        try {
            result_bitmap =   BitmapFactory.decodeStream(res.openRawResource(resource_id), null, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_bitmap;
    }

}

