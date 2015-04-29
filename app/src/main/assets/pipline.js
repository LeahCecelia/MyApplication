function makePipeline(tableid, numRows) {  
            var i;
            for(i = 0; i < numRows; i++){
                var start = getStart(i, numRows, tableid);
                var middle = "<td class = '"+tableid+"_"+(i)+" "+tableid+"_row_"+i+"'><img src = 'IM.png' class = 'InstFetchImg'></td><td class = '"+tableid+"_"+(i+1)+" "+tableid+"_row_"+i+"'><img src = 'Reg1.png' class = 'Reg1Img'></td><td class = '"+tableid+"_"+(i+2)+" "+tableid+"_row_"+i+"'><img src = 'ALU.png' class = 'ALUImg'></td><td class = '"+tableid+"_"+(i+3)+" "+tableid+"_row_"+i+"'><img src = 'DM.png' class = 'DMImg'></td><td class = '"+tableid+"_"+(i+4)+" "+tableid+"_row_"+i+"'><img src = 'Reg2.png' class = 'Reg2Img'></td>";
                var end = getEnd(i, numRows);
                $("#"+tableid).append(start+middle+end);
            }
        }
        
        function getStart(it, numRows, tableid){
            var s = "<tr>";
            var i;
            for(i = 0; i < it; i++){
                s += "<td></td>";
            }
            return s;
        }
        
        function getEnd(it, numRows){
            var s = "";
            var i;
            var numCols = 5 + numRows - 1;
            for(i = it + 5; i <= numCols; i++){
                s += "<td></td>";
            }
            s += "</tr>";
            return s;
        }
        
        function movePipeline(tableid, hazardcol1, hazardrow1, hazardcol2, hazardrow2){
            var i = -1;
            var atEnd = false;
            while(!atEnd){
                i++;
                if($("."+tableid+"_"+i)[0]){
                    $("."+tableid+"_"+i).each(function () {
                        if( !$(this).hasClass("highlight") && !$(this).hasClass("hazard") ){
                            atEnd = true;
                        }
                        if(atEnd && (atHazardCell(this, hazardcol1, hazardrow1, tableid) || atHazardCell(this, hazardcol2, hazardrow2, tableid))){
                            $(this).addClass("hazard");
                        }
                    });
                }else{
                    atEnd = true;
                    i = -1;
                }
            }
            if(i != -1){
                $("."+tableid+"_"+i).each(function () {
                    if(!$(this).hasClass("hazard")){
                        $(this).addClass("highlight");
                    }
                });
            }else{
                restartAnimation(tableid);
            }
        }
        
        function atHazardCell(td, hazardcol, hazardrow, tableid){
            var rowclass = tableid+"_row_"+hazardrow;
            var colclass = tableid+"_"+hazardcol;
            return $(td).hasClass(rowclass) && $(td).hasClass(colclass);
        }
        
        function restartAnimation(tableid){
            $("#"+tableid+" td").each( function () {
                $(this).removeClass("highlight");
                $(this).removeClass("hazard");
            });
        }
    