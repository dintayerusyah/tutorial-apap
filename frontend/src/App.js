import React from 'react';

import List from '../src/components/List/index';
import listMovies from '../src/movies.json';
import EmptyState from '../src/components/EmptyState/index'
import "./App.css";

export default class App extends React.Component{
  state = {
    favItems: []
  };

  handleItemClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = {...item};
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if(targetInd < 0) newItems.push(newItem);
    // latihan no 3
    // else newItems.splice(targetInd, 1);
    this.setState({favItems: newItems});
  };

  // latihan no 2
  clearFavs=()=>{
    this.setState({favItems: []});
  }

  // latihan no 4
  showFavs=()=>{
    const {show} = this.state;
    this.setState({show: !show});
  }

  render(){
    const {favItems} = this.state;
    return(
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="text-center">
          <div class="custom-control custom-switch">
            <input type="checkbox" class="custom-control-input" id="customSwitch1" onChange={this.showFavs}></input>
            <label class="custom-control-label" for="customSwitch1">Show Favorites</label>
          </div>
        </div>
        <div className="container pt-3">
          <div className="row">
            {/* latihan no 2 */}
            {this.state.favItems.length? <button className="btn btn-danger" onClick={this.clearFavs}>Remove All Favorites</button>:null}
          </div>
          <br/>
          <div className="row">
            <div className="col-sm">
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={this.handleItemClick}
              ></List>
            </div>
            {/* latihan no 4 */}
            {this.state.show?
            <div className="col-sm">
              {/* latihan no 5 */}
              {!this.state.favItems.length? <EmptyState/> : 
              <List
                title="My Favorites"
                items={favItems}
                onItemClick={this.handleItemClick}
              />}
            </div>
            :null}
          </div>
        </div>
      </div>
    );
  }
}
