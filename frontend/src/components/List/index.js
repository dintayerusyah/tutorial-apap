import React from 'react';
import Item from '../Item/index'

export default function List({title, items, onItemClick}){
    return(
        <>
            <h3 style={styles.heading}>{title}</h3>
            <div className="list-group">
                {items.map((item) => (
                    <Item key={item.id} item={item} onChange={onItemClick}></Item>
                ))}
            </div>
        </>
    );
}

const styles = {
    heading: {
        fontFamily: "courier-new",
    },
};