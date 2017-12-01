set runtimepath+=~/.vim_runtime

source ~/.vim_runtime/vimrcs/basic.vim
source ~/.vim_runtime/vimrcs/filetypes.vim
source ~/.vim_runtime/vimrcs/plugins_config.vim
source ~/.vim_runtime/vimrcs/extended.vim

try
source ~/.vim_runtime/my_configs.vim
catch
endtry

set nocompatible              " be iMproved, required
filetype off                  " required

" set the runtime path to include Vundle and initialize
set rtp+=~/.vim/bundle/Vundle.vim
call vundle#begin()
" alternatively, pass a path where Vundle should install plugins
"call vundle#begin('~/some/path/here')

" let Vundle manage Vundle, required
Plugin 'VundleVim/Vundle.vim'

" The following are examples of different formats supported.
" Keep Plugin commands between vundle#begin/end.
" plugin on GitHub repo
Plugin 'tpope/vim-fugitive'
" plugin from http://vim-scripts.org/vim/scripts.html
" Plugin 'L9'
" Git plugin not hosted on GitHub
Plugin 'git://git.wincent.com/command-t.git'
" git repos on your local machine (i.e. when working on your own plugin)
Plugin 'file:///home/gmarik/path/to/plugin'
" The sparkup vim script is in a subdirectory of this repo called vim.
" Pass the path to set the runtimepath properly.
Plugin 'rstacruz/sparkup', {'rtp': 'vim/'}
" Install L9 and avoid a Naming conflict if you've already installed a
" different version somewhere else.
" Plugin 'ascenator/L9', {'name': 'newL9'}

" All of your Plugins must be added before the following line
Plugin 'junegunn/seoul256.vim'



call vundle#end()            " required
filetype plugin indent on    " required
" To ignore plugin indent changes, instead use:
"filetype plugin on
"
" Brief help
" :PluginList       - lists configured plugins
" :PluginInstall    - installs plugins; append `!` to update or just :PluginUpdate
" :PluginSearch foo - searches for foo; append `!` to refresh local cache
" :PluginClean      - confirms removal of unused plugins; append `!` to auto-approve removal
"
" see :h vundle for more details or wiki for FAQ
" Put your non-Plugin stuff after this line

"addon
set nu
syntax enable
set background=dark 
colorscheme peaksea 

"show colorscheme
nmap <F8> :set background=dark<cr>:colo peaksea<cr>
nmap <F9> :colo seoul256-light<cr>

"tab switch
nmap <F3> :tabn<cr>
nmap <F2> :tabp<cr>
"new tab
nmap <F4> :tabnew<cr>
"close tab
nmap <F12> :tabclose<cr>
"recently file
nmap <F6> :MRU<cr>
"nerdtree
nmap <F5> :NERDTreeToggle<cr>:wincmd r<cr>

"automatically fold functions
"set foldmethod=indent
"set foldlevel=1
"set foldclose=all
"zo open fold
"nmap ,z zO
"zc colse
"zR stop

"compile key
autocmd FileType java map <F7> :!javac "%:p" && java -cp "%:p:h" "%:t:r"<CR>
