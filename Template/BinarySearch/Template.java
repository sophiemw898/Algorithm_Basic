Public int firstFirstRed(int n){
    if(n<0)
        return integer.min_valuel;
    int start = 1;
    int end = n;
    while(start < end-1){
        int mid = start + (start + end)/2;
        if(target == check(mid)){
            find(mid);
        }else if(target in (check(mid), check(end))){
            start = mid;
        }else{
            end = mid
        }  
    }
    return isRed(start) ? start : end;
}

//<= ensure mid = start = end can be returned
int binary_search(const int nums[], int start, int end, int target) {
    while(start <= end){ 
        int mid = start + (end - start)/2;
        if(target == nums[mid]){
            return mid;
            }else if(target > nums[mid]){
                start = mid + 1;
                }else{
                    end = mid - 1;//end = mid may be wuxian xunhuan
                }
     }
     return -1;
}
  
