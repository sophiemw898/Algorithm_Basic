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
